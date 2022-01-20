package model.attack;

import model.Direction;
import model.entities.Personnage;

//interface de création d'une attaque
public interface Attacker {
    //créer uine attaque à partir d'un personnage et d'une direction
    Attack attack(Personnage pers, Direction dir); //attaque à rajouter quand fait
}
