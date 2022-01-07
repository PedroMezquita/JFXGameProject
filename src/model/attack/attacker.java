package model.attack;

import model.deplacement.Direction;
import model.entities.Personnage;

public interface attacker {
    public void attack(Personnage pers, Direction dir, Attack atk); //attaque à rajouter quand fait
}
