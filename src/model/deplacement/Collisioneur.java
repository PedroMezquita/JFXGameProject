package model.deplacement;

import model.maps.Map;
import model.entities.Personnage;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Collisioneur {//point d'extensibilité
    public int testCollision(Personnage pers, Direction dir);
}
