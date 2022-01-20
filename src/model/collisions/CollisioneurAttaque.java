package model.collisions;

import model.attack.Attack;
import model.maps.Map;

//interface de test de collisions des attaques
public interface CollisioneurAttaque {
    //test si une attaque touche
    void hitTest(Attack atk, Map map);
}
