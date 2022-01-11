package model.attack;

import model.entities.Entite;
import model.entities.Personnage;

public class Attack extends Entite {

    int lifeTime;
    int degat;

    public Attack(int lifeTime, int degat, int xPos, int yPos, int xSize, int ySize, String id){
        super(xPos, yPos, xSize, ySize, id);
        this.lifeTime = lifeTime;
    }

}
