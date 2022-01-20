package model.collisions;

import model.attack.Attack;
import model.attack.Damager;
import model.attack.DamagerSimple;
import model.entities.Ennemi;
import model.entities.Personnage;
import model.maps.Map;

import java.util.ArrayList;
import java.util.Hashtable;

public class CollisioneurAttaqueEnnemi implements CollisioneurAttaque{

    //sert dans le cas où l'attaque touche
    private Damager dmg = new DamagerSimple();

    @Override
    public void hitTest(Attack atk, Map map) {



        int atkx = atk.getPos().getxPos();
        int atky = atk.getPos().getyPos();
        ArrayList<Ennemi> hits = new ArrayList<Ennemi>();

        //pour chaque ennemi
        for (Ennemi enemi : map.getEnnemis()){
            //Calcul de la hitbox de l'ennemi
            int enemiMinY = enemi.getPos().getyPos(), enemiMaxY = enemi.getPos().getyPos()+enemi.getySize(), enemiMinX = enemi.getPos().getxPos(), enemiMaxX = enemi.getPos().getxPos()+enemi.getxSize();

            //si ((le y minimum/maximum du enemi est compris entre les y de l'attaque) ou (les y de l'ennemi sont compris entre les y de l'atk)) et la cible n est pas celui qui à lancé l'attaque
            if (((enemiMinY >= atky && enemiMinY <= atky+atk.getySize()) || (enemiMaxY >= atky && enemiMaxY <= atky+atk.getySize()) || (enemiMaxY >= atky+atk.getySize() && enemiMinY <= atky)) && atk.getPerso() != (Personnage) enemi){
                //la même avec le X
                if (((enemiMinX >= atkx && enemiMinX <= atkx+atk.getxSize()) || (enemiMaxX >= atkx && enemiMaxX <= atkx+atk.getxSize()) || (enemiMaxX >= atkx+atk.getxSize() && enemiMinX <= atkx))){
                    //si il y a collision, on ajoute l'ennemi à la liste des touche
                    hits.add(enemi);
                }
            }
        }
        //on inflige les dégats au touches
        dmg.enemiHit(atk,hits,map);
    }
}
