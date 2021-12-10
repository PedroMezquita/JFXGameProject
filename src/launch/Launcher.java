package launch;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.deplacement.Collisioneur;
import model.deplacement.CollisioneurBase;
import model.deplacement.Direction;
import model.entities.Entite;
import model.entities.Guerrier;
import model.entities.Personnage;
import model.maps.Map;
import model.maps.TestMap;
import vue.Background1;

import model.deplacement.*;

public class Launcher extends Application{

    //les trucs abstract servent à faire les points d'extensibilité pour que le code soit SOLID comme on l'apprend en cours, parce que c'est demandé.
    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(this.getClass().getResource("/Background1.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
        DeplacerJoueur deplace = new DeplacerJoueur();//On garde une direction (a la base elle est nulle
        Direction dir = new Direction(0,0);
        Personnage joueur = new Guerrier(1,1,10,10,10,10,10,"mec",1,1,0,0,0);



        scene.setOnKeyPressed(event -> {
            String codeString = event.getCode().toString();
            dir.detectDirection(codeString); //On appelle a la methode qui va changer la direction lors que une touche est utilisé
            deplace.deplacer(joueur,dir);
            //System.out.println("position x : "+joueur.getPos().getxPos()+", position y : "+joueur.getPos().getyPos());
            root.setTranslateX(joueur.getPos().getxPos());
            root.setTranslateY(joueur.getPos().getyPos()); //déplace l'entiereté du parent, je sais pas comment appeler le code behind pour toucher uniquement au cercle bleu
        });




        /*
        Personnage entity = new Guerrier(1, 1, 10, 10, 10, 10, 1, "Arnold",3,3,20,20, 1);
        Map map = new TestMap();
        map.addEntity(entity);
        System.out.println(map.toString());
        Collisioneur coll = new CollisioneurBase();
        System.out.println(coll.testCollision(entity, new Direction(1,1), map));
*/

    }
}


/*
COMMENT FAIRE DES PROPRIETES JFX
private StringProperty toto = new SimpleStringProperty();
    public String getToto{return toto.get();
    public void setToto(String value){toto.set(valeur);}
    public ReadOnlyStringProperty totoProperty(){return toto;}

objet.propiete().bind(objet2.property())
-------------bindBidirectionel(------);
<Button text="${objet.prop}" />
 */