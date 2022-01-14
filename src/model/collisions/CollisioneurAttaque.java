package model.collisions;

import model.attack.Attack;
import model.maps.Map;

public interface CollisioneurAttaque {

    public int hitTest(Attack atk, Map map);
}
