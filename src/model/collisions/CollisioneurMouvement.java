package model.collisions;

import model.Direction;
import model.entities.Personnage;

public interface CollisioneurMouvement {//point d'extensibilité
    public int testCollision(Personnage pers, Direction dir);
}
