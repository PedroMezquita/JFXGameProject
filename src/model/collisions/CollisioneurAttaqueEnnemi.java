package model.collisions;

import model.attack.Attack;
import model.entities.Ennemi;
import model.maps.Map;

import java.util.ArrayList;

public class CollisioneurAttaqueEnnemi implements CollisioneurAttaque{

    //Ceci est provisionnel, faudrais dedier une journée a optimiser ce code la
    @Override
    public int hitTest(Attack atk, Map map) {
        ArrayList<Ennemi> listeEnnemis = map.getEnnemis();

        int atkx = atk.getPos().getxPos();
        int atky = atk.getPos().getyPos();

        //pour chaque ennemi
        for (Ennemi enemi : listeEnnemis){
            //Calcul de la hitbox de l'ennemi
            int enemiMinY = enemi.getPos().getyPos(), enemiMaxY = enemi.getPos().getyPos()+enemi.getySize(), enemiMinX = enemi.getPos().getxPos(), enemiMaxX = enemi.getPos().getxPos()+enemi.getxSize();

            //si ((le y minimum/maximum du enemi est compris entre les y de l'attaque
            if (((enemiMinY >= atky && enemiMinY <= atky+atk.getySize()) || (enemiMaxY >= atky && enemiMaxY <= atky+atk.getySize()) || (enemiMaxY >= atky+atk.getySize() && enemiMinY <= atky))){
                //la même avec le X
                if (((enemiMinX >= atkx && enemiMinX <= atkx+atk.getxSize()) || (enemiMaxX >= atkx && enemiMaxX <= atkx+atk.getxSize()) || (enemiMaxX >= atkx+atk.getxSize() && enemiMinX <= atkx))){
                    return 0;
                }
            }
        }
        return 1;
    }
}
