package data;

import model.attack.AttackPattern;
import model.entities.Ennemi;
import model.entities.Joueur;
import model.entities.Personnage;
import model.entities.Props;
import model.maps.Map;

public class Niveau1 extends Niveau{

    @Override
    public Map load() {
        Map map = new Map();
        Props obstacle1 = new Props(500,10,0,0,"Mur haut");
        obstacle1.setRGB(0,0,0);
        obstacle1.setSprite("TemplateWall.png");
        map.addEntity(obstacle1);
        Props obstacle2 = new Props(10,500,490,0,"Mur droite");
        obstacle2.setRGB(0,0,0);
        obstacle2.setSprite("TemplateWall.png");
        map.addEntity(obstacle2);
        Props obstacle3 = new Props(500,10,0,490,"Mur bas");
        obstacle3.setRGB(0,0,0);
        obstacle3.setSprite("TemplateWall.png");
        map.addEntity(obstacle3);
        Props obstacle4 = new Props(10,500,0,0,"Mur gache");
        obstacle4.setRGB(0,0,0);
        obstacle4.setSprite("TemplateWall.png");
        map.addEntity(obstacle4);
        Personnage joueur = new Joueur(1,10,10,5,"mec", /* 21*/ 41, /* 21*/41,20,20,"joueur", 1,0,0); //Le joueur charge avant les props
        joueur.setSprite("TemplateCharacter.png");
        AttackPattern atqJoueur = new AttackPattern(25, 2, 10, 25, "trait", 50);
        atqJoueur.setRGB(0.5,0.5,1);
        joueur.setAttaque(atqJoueur);
        map.addEntity(joueur);
        Ennemi ennemi = new Ennemi(1,1,1,5, 15, 15, 250, 400, "ennemi1", 1,1,0);
        ennemi.setSprite("TemplateEnnemi.png");
        AttackPattern atqEnemi = new AttackPattern(20,1,15,15,"slime",5);
        atqEnemi.setRGB(0,1,0);
        ennemi.setAttaque(atqEnemi);
        map.addEnemy(ennemi);
        map.setImage("TemplateBackground.png");
        return map;
    }

}
