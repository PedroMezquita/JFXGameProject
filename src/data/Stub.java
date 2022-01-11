package data;

import model.Direction;
import model.attack.AttackPattern;
import model.entities.Guerrier;
import model.entities.Personnage;
import model.entities.Props;
import model.maps.Map;
import model.maps.TestMap;

public class Stub implements Loader{

    public Map load (){
        Map map = new TestMap();
        Personnage joueur = new Guerrier(1,1,10,10,10,10,1,"mec",21,21,0,0,"joueur"); //Le joueur charge avant les props
        AttackPattern atq = new AttackPattern(1,1,10,10,"base");
        joueur.setAttaque(atq);
        map.addEntity(joueur);
        Direction dir = new Direction(0,0);
        Props obstacle1 = new Props(50,15,150,47,"obst");
        map.addEntity(obstacle1);
        return map;
    }
}
