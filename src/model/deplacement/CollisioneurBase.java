package model.deplacement;

import model.maps.Map;
import model.entities.Personnage;

public class CollisioneurBase implements Collisioneur{


    @Override
    public boolean testCollision(Personnage pers, Direction dir, Map map) {
        return false;
    }
}

