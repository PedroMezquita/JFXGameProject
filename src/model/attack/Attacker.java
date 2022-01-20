package model.attack;

import model.Direction;
import model.entities.Personnage;
import model.maps.Map;

public interface Attacker {
    public Attack attack(Personnage pers, Direction dir); //attaque à rajouter quand fait
}
