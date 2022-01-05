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
import model.BeepObserver;
import model.Loop;
import model.Manager;
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

    private static Stage stage;
    private static Manager manager;

    //les trucs abstract servent à faire les points d'extensibilité pour que le code soit SOLID comme on l'apprend en cours, parce que c'est demandé.
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Chargement du scenario
        stage = primaryStage;
        Parent root = FXMLLoader.load(this.getClass().getResource("/Background1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        manager = new Manager();



        /*
        Personnage entity = new Guerrier(1, 1, 10, 10, 10, 10, 1, "Arnold",3,3,20,20, 1);
        Map map = new TestMap();
        map.addEntity(entity);
        System.out.println(map.toString());
        Collisioneur coll = new CollisioneurBase();
        System.out.println(coll.testCollision(entity, new Direction(1,1), map));
*/

    }

    public static Manager getManager() {
        return manager;
    }

    public static Stage getStage() {
        return stage;
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