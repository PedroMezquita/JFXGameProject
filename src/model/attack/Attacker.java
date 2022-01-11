package model.attack;

import model.Direction;
import model.entities.Personnage;

public interface Attacker {
    public Attack attack(Personnage pers, Direction dir); //attaque à rajouter quand fait
}
