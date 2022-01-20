package model.collisions;

import model.attack.*;
import model.entities.Ennemi;
import model.entities.Personnage;
import model.maps.Map;

import java.util.ArrayList;

public class CollisioneurAttaqueJoueur implements CollisioneurAttaque{

    private DamagerEnnemi dmg = new DammagerSimpleEnnemi();

    @Override
    public void hitTest(Attack atk, Map map) {

        int atkx = atk.getPos().getxPos();
        int atky = atk.getPos().getyPos();
        Personnage hits = map.getJoueur();
        ArrayList<Personnage> allHits = new ArrayList<>();
            //Calcul de la hitbox de l'ennemi
        //S'il n'y a pas de joueur alors la partie est fini et ceci ne peut arriver qu'une fois les loops sont interrompues
        if (hits == null ){return;}
            int persMinY = hits.getPos().getyPos(), persMaxY = hits.getPos().getyPos()+hits.getySize(), persMinX = hits.getPos().getxPos(), persMaxX = hits.getPos().getxPos()+hits.getxSize();

        //si ((le y minimum/maximum du enemi est compris entre les y de l'attaque) ou (les y de l'ennemi sont compris entre les y de l'atk)) et la cible n est pas celui qui à lancé l'attaque
            if (((persMinY >= atky && persMinY <= atky+atk.getySize()) || (persMaxY >= atky && persMaxY <= atky+atk.getySize()) || (persMaxY >= atky+atk.getySize() && persMinY <= atky))){
                //la même avec le X
                if (((persMinX >= atkx && persMinX <= atkx+atk.getxSize()) || (persMaxX >= atkx && persMaxX <= atkx+atk.getxSize()) || (persMaxX >= atkx+atk.getxSize() && persMinX <= atkx))){
                    allHits.add(hits);
                }
            }
        dmg.personnageHit(atk, allHits, map);
    }
}
