package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import model.deplacement.Collisioneur;
import model.deplacement.CollisioneurBase;
import model.deplacement.Direction;
import model.entities.Entite;
import model.entities.Guerrier;
import model.entities.Personnage;
import model.maps.Map;
import model.maps.TestMap;

public class Launcher extends Application{

    //les trucs abstract servent à faire les points d'extensibilité pour que le code soit SOLID comme on l'apprend en cours, parce que c'est demandé.
    @Override
    public void start(Stage primaryStage) throws Exception {
        Personnage entity = new Guerrier(1, 1, 10, 10, 10, 10, 1, "Arnold",3,3,20,20, 1);
        Map map = new TestMap();
        map.addEntity(entity);
        System.out.println(map.toString());
        Collisioneur coll = new CollisioneurBase();
        System.out.println(coll.testCollision(entity, new Direction(1,1), map));
    }
}
