package model.attack;

import model.collisions.CollisioneurAttaque;
import model.collisions.CollisioneurAttaqueEnnemi;
import model.entities.Ennemi;
import model.maps.Map;

import java.util.ArrayList;

public class DamagerSimple implements Damager{



    public void enemiHit(Attack atk, ArrayList<Ennemi> hits, Map map) {
        for (Ennemi enemy : hits) {
            enemy.setCurrentHP(enemy.getCurrentHP() - atk.getDegat());
            atk.setLifeTime(1);
            System.out.println("aie");
            System.out.println(atk.getDegat());
            if (enemy.getCurrentHP() <= 0) {
                map.removeEnemy(enemy);
                System.out.println("je meurt");
            }
        }
    }

}
