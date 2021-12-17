package model.deplacement;

import model.maps.Map;
import model.entities.Personnage;

public interface Collisioneur {//point d'extensibilité
    public boolean testCollision(Personnage pers, Direction dir);
}
