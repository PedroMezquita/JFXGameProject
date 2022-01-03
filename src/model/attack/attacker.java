package model.attack;

import model.deplacement.Direction;
import model.entities.Personnage;

public interface attacker {
    public void deplacer(Personnage pers, Direction dir); //attaque à rajouter quand fait
}
