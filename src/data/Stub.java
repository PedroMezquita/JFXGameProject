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
        Personnage joueur = new Joueur(1,1,10,10,10,10,5,"mec", /* 21*/ 41, /* 21*/41,0,0,"joueur", 1,0,0); //Le joueur charge avant les props
        //---TEST
        joueur.setSprite("TemplateCharacter.png");
        //---TEST

        Ennemi ennemi = new Ennemi(1,1,10,10,10,10,5, 15, 15, 100, 100, "ennemi1", 1,1,0);
        //---TEST
        ennemi.setSprite("TemplateEnnemi.png");
        //---TEST


        map.addEnemy(ennemi);
        Ennemi ennemi2 = new Ennemi(1,1,50,10,50,10,5, 75, 75, 200, 200, "ennemi3", 1,0,1);

        //---TEST
        ennemi2.setSprite("TemplateEnnemi.png");
        //---TEST

        map.addEnemy(ennemi2);
        AttackPattern atq = new AttackPattern(10,1,20,10,"base");
        joueur.setAttaque(atq);
        ennemi.setAttaque(atq);
        ennemi2.setAttaque(atq);
        map.addEntity(joueur);
        Direction dir = new Direction(0,0);
        Props obstacle1 = new Props(50,15,150,47,"obst", 0,0,0);
        map.addEntity(obstacle1);
        return map;
    }
}
