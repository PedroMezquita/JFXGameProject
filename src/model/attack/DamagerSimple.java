package model.attack;

import model.collisions.CollisioneurAttaque;
import model.collisions.CollisioneurAttaqueEnnemi;
import model.entities.Ennemi;
import model.entities.Personnage;
import model.maps.Map;

import java.util.ArrayList;

public class DamagerSimple implements Damager{


    @Override
    public void enemiHit(Attack atk, ArrayList<Ennemi> hits, Map map) {
        for (Ennemi enemy : hits) {
            enemy.setCurrentHP(enemy.getCurrentHP() - atk.getDegat());
            atk.setLifeTime(1);
            if (enemy.getCurrentHP() <= 0) {
                map.removeEnemy(enemy);
            }
        }
    }

}
