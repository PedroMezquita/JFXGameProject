package launch;

import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import model.Loop;
import model.deplacement.Collisioneur;
import model.deplacement.CollisioneurCarre;
import model.deplacement.Direction;
import model.entities.Entite;
import model.entities.Guerrier;
import model.entities.Personnage;
import model.entities.Props;
import model.maps.Map;
import model.maps.TestMap;
import vue.Background1;

import model.deplacement.*;

import java.util.ArrayList;


public class Launcher extends Application{

    //les trucs abstract servent à faire les points d'extensibilité pour que le code soit SOLID comme on l'apprend en cours, parce que c'est demandé.
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Chargement du scenario
        Parent root = FXMLLoader.load(this.getClass().getResource("/Background1.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();




        /*
        Loop beep = new Loop();
        beep.start();
        */


        //Detection et ajout du joueur (cercle)
        Rectangle cercle = (Rectangle) root.lookup("#cercle");


        //Detection et ajout des obstacles dans la liste obstacles
        Rectangle obst1 = (Rectangle) root.lookup("#obst1");
        Props obstacle1 = new Props(50,15,150,47,1);
        obst1.setHeight(obstacle1.getySize()); //hauteur = y, largeur = x
        obst1.setWidth(obstacle1.getxSize());
        obst1.setX(obstacle1.getPos().getxPos());
        obst1.setY(obstacle1.getPos().getyPos());

        Rectangle reference = (Rectangle) root.lookup("#milieuJoueur");
        reference.setHeight(3); //hauteur = y, largeur = x
        reference.setWidth(3);
        reference.setX(obstacle1.getPos().getxPos()+obstacle1.getxSize());
        reference.setY(obstacle1.getPos().getyPos()+obstacle1.getySize());

        //Instances des classes necessaires

        Map map = new TestMap();
        map.addEntity(obstacle1);
        Direction dir = new Direction(0,0);
        Personnage joueur = new Guerrier(1,1,10,10,10,10,10,"mec",21,21,0,0,0);
        cercle.setHeight(joueur.getySize());
        cercle.setWidth(joueur.getxSize());
        cercle.setX(joueur.getPos().getxPos());
        cercle.setY(joueur.getPos().getyPos());
        map.addEntity(joueur);
        DeplacerJoueur deplace = new DeplacerJoueur(new CollisioneurCarre(map));//On garde une direction (a la base elle est nulle


        //Detection des touches (methode lambda qui va gerer le deplacement et l'interaction avec le joueur)
        scene.setOnKeyPressed(event -> {
            String codeString = event.getCode().toString();
            dir.detectDirection(codeString); //On appelle a la methode qui va changer la direction lors que une touche est utilisé

            //boolean col = colision.testCollisionsCercle(cercle, joueur); //ça ne marche pas, je vais faire le beep je pense
                deplace.deplacer(joueur,dir);
                //System.out.println("position x : "+joueur.getPos().getxPos()+", position y : "+joueur.getPos().getyPos());
                //root.setTranslateX(joueur.getPos().getxPos());
                //root.setTranslateY(joueur.getPos().getyPos()); //déplace l'entiereté du parent, je sais pas comment appeler le code behind pour toucher uniquement au cercle bleu
                cercle.setX(joueur.getPos().getxPos());
                cercle.setY(joueur.getPos().getyPos());
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





 Boucleur: juste beep
 */