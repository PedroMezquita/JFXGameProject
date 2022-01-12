package model.attack;

import model.entities.Entite;
import model.entities.Personnage;

public class Attack extends Entite {

    private int lifeTime;
    private int degat;
    private Personnage perso;

    public Attack(int lifeTime, int degat, int xPos, int yPos, int xSize, int ySize, String id, Personnage perso){
        super(xSize, ySize, xPos, yPos, id);
        this.lifeTime = lifeTime;
        this.perso = perso;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public Personnage getPerso() {
        return perso;
    }
}
