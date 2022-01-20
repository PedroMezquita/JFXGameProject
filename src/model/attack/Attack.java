package model.attack;

import model.Direction;
import model.entities.Entite;
import model.entities.Personnage;

//classe métier Attack
public class Attack extends Entite {

    //temps de vie de l'attaque correspondant au nombre de déplacements (ou tour de boucle)
    private int lifeTime;
    //nombre de degats infligés par l'attaque
    private int degat;
    //personnage ayant lancé l'attaque
    private Personnage perso;
    //direction de l'attaque
    private Direction dir;

    public Attack(int lifeTime, int degat, int xPos, int yPos, int xSize, int ySize, String id, Personnage perso, Direction dir){
        super(xSize, ySize, xPos, yPos, id);
        this.lifeTime = lifeTime;
        this.perso = perso;
        this.dir = dir;
        this.degat = degat;
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

    public Direction getDir() {return dir;}

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }
}
