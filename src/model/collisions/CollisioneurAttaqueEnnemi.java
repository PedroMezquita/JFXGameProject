package model.collisions;

import model.attack.Attack;
import model.attack.Damager;
import model.attack.DamagerSimple;
import model.entities.Ennemi;
import model.maps.Map;

import java.util.ArrayList;
import java.util.Hashtable;

public class CollisioneurAttaqueEnnemi implements CollisioneurAttaque{

    private Damager dmg = new DamagerSimple();

    //Ceci est provisionnel, faudrais dedier une journée a optimiser ce code la
    @Override
    public void hitTest(Attack atk, Map map) {



        int atkx = atk.getPos().getxPos();
        int atky = atk.getPos().getyPos();
        ArrayList<Ennemi> hits = new ArrayList<Ennemi>();

        //pour chaque ennemi
        for (Ennemi enemi : map.getEnnemis()){
            //Calcul de la hitbox de l'ennemi
            int enemiMinY = enemi.getPos().getyPos(), enemiMaxY = enemi.getPos().getyPos()+enemi.getySize(), enemiMinX = enemi.getPos().getxPos(), enemiMaxX = enemi.getPos().getxPos()+enemi.getxSize();

            //si ((le y minimum/maximum du enemi est compris entre les y de l'attaque
            if (((enemiMinY >= atky && enemiMinY <= atky+atk.getySize()) || (enemiMaxY >= atky && enemiMaxY <= atky+atk.getySize()) || (enemiMaxY >= atky+atk.getySize() && enemiMinY <= atky))){
                //la même avec le X
                if (((enemiMinX >= atkx && enemiMinX <= atkx+atk.getxSize()) || (enemiMaxX >= atkx && enemiMaxX <= atkx+atk.getxSize()) || (enemiMaxX >= atkx+atk.getxSize() && enemiMinX <= atkx))){
                    hits.add(enemi);
                }
            }
        }
        dmg.enemiHit(atk,hits,map);
    }
}
