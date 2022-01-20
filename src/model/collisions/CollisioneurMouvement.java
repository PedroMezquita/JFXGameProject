package model.collisions;

import model.Direction;
import model.entities.Personnage;
//interface de la collision lors du déplacement des personnage
public interface CollisioneurMouvement {
    //test si un personnage va rentrer en collision avec qqch en se déplaçant
    boolean testCollision(Personnage pers, Direction dir);
}
