package model.collisions;

import model.Direction;
import model.entities.Personnage;

public class CollisioneurEnnemi implements CollisioneurMouvement{
    @Override
    public int testCollision(Personnage pers, Direction dir) {
        return 1;
    }
}
