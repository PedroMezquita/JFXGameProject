package model.attack;

import model.entities.Personnage;

public class Attack {
    Degat degat;
    Range range;

    public Attack(Range range, Personnage pers){
        this.degat = new Degat(pers);
        this.range = range;
    }

}
