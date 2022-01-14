package data;

import model.Direction;
import model.attack.AttackPattern;
import model.entities.Ennemi;
import model.entities.Joueur;
import model.entities.Personnage;
import model.entities.Props;
import model.maps.Map;
import model.maps.TestMap;

public class Stub implements Loader{

    public Map load (){
        Map map = new TestMap();
        Personnage joueur = new Joueur(1,1,10,10,10,10,5,"mec",21,21,0,0,"joueur"); //Le joueur charge avant les props
        Personnage ennemi = new Ennemi(1,1,10,10,10,10,5, 15, 15, 100, 100, "ennemi");
        AttackPattern atq = new AttackPattern(10,1,10,10,"base");
        joueur.setAttaque(atq);
        map.addEntity(joueur);
        map.addEntity(ennemi);
        Direction dir = new Direction(0,0);
        Props obstacle1 = new Props(50,15,150,47,"obst");
        map.addEntity(obstacle1);
        return map;
    }
}
