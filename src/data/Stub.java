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
        Personnage joueur = new Joueur(1,1,10,10,10,10,5,"mec",21,21,0,0,"joueur", 1,0,0); //Le joueur charge avant les props
        Ennemi ennemi = new Ennemi(1,1,10,10,10,10,5, 15, 15, 100, 100, "ennemi", 1,1,0);
        map.addEnemy(ennemi);
        Ennemi ennemi1 = new Ennemi(1,1,100,10,100,10,5, 150, 150, 100, 300, "ennemi", 1,0,1);
        map.addEnemy(ennemi1);
        Ennemi ennemi2 = new Ennemi(1,1,50,10,50,10,5, 75, 75, 200, 200, "ennemi", 1,0,1);
        map.addEnemy(ennemi2);
        AttackPattern atq = new AttackPattern(10,1,10,10,"base");
        joueur.setAttaque(atq);
        ennemi.setAttaque(atq);
        ennemi1.setAttaque(atq);
        ennemi2.setAttaque(atq);
        map.addEntity(joueur);
        Direction dir = new Direction(0,0);
        Props obstacle1 = new Props(50,15,150,47,"obst", 0,0,0);
        map.addEntity(obstacle1);
        return map;
    }
}
