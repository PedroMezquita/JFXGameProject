package model.attack;

import model.Direction;
import model.collisions.CollisioneurAttaque;
import model.collisions.CollisioneurAttaqueEnnemi;
import model.entities.Position;
import model.maps.Map;

public class AtkUpdater {

    private CollisioneurAttaque colAtk;

    public void updateAttack(Map map){

        for (Attack atk : map.getAllAttacks()) {
            atk.setLifeTime(atk.getLifeTime()-1);
            if (atk.getLifeTime() == 0){
                map.removeAttack(atk);
                atk.getPerso().setCurrentAttack(null);
            }else{
                deplaceAttack(atk);
                enemiHit(atk, map);

            }
        }
    }

//Ce serais une bonne idée d'avoir une vitesse d'attaque pour ça, en tout cas je le laisse a 10 ça devrais le faire
    //Tirer a droite ou en bas ne fait aucune influence dans le collisionneur mais tirer en haut ou a gauche ça empeche le joueur de se deplacer dans cette direction (enfait ça ne marche que la moitie des fois)
    public void deplaceAttack(Attack atk){
        Direction dir = atk.getDir();
        Position oldPos = atk.getPos();
        if(dir.getyDir() == -1){
            atk.setPosition(oldPos.getxPos(), oldPos.getyPos()-10);
        }
         if(dir.getyDir() == 1){
            atk.setPosition(oldPos.getxPos(), oldPos.getyPos()+10);
        }
        if(dir.getxDir() == -1){
            atk.setPosition(oldPos.getxPos()-10, oldPos.getyPos());
        }
        if(dir.getxDir() == 1){
            atk.setPosition(oldPos.getxPos()+10, oldPos.getyPos());
        }
    }

    public void enemiHit(Attack atk, Map map){
        this.colAtk = new CollisioneurAttaqueEnnemi();
        int i = colAtk.hitTest(atk, map);
        if (i == 0){
            /*
            METTRE ICI LE CODE LORS QU'ON ATTAQUE A UN ENNEMI
            Je propose: Lorsqu'un enemi est touche reenvoyer le code de collision et l'ennemi
             */
            System.out.println("AOUCH, ça pique");
        }
    }

}
