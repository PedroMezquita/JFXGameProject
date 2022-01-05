package data;

import javafx.scene.shape.Rectangle;
import launch.Launcher;
import model.deplacement.Direction;
import model.entities.Guerrier;
import model.entities.Personnage;
import model.entities.Props;
import model.maps.Map;
import model.maps.TestMap;

public class Stub implements Loader{

    public Map load (){
        Map map = new TestMap();
        Rectangle obst1 = (Rectangle) Launcher.getStage().getScene().getRoot().lookup("#obst1");
        Props obstacle1 = new Props(50,15,150,47,1);
        map.addEntity(obstacle1);
        Direction dir = new Direction(0,0);
        Personnage joueur = new Guerrier(1,1,10,10,10,10,10,"mec",21,21,0,0,0);
        map.addEntity(joueur);
        return map;
    }
}
