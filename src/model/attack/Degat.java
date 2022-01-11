package model.attack;

import model.entities.Personnage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Degat { //Pas opti du tout maaaais je veux voir si ça marche au moins (desole garbage collection, ceci n'est pas personnel)

    private int degat;

    public Degat(Personnage pers){ //Possible probleme de conception, Une attaque n'existe pas selon notre ancien modele, on trouve un Degat et une porté separées entre elles, faudrais faire le contrire, un attaque POSSEDE un degat et une portée (et donc c'est pas une interface)
        int degatBase = 1+pers.getAtkPnt();
        int degatTotal = ThreadLocalRandom.current().nextInt(degatBase/2, degatBase*2);
        System.out.println(degatTotal);
        degat = degatTotal;
    }


    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }
}
