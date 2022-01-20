package model.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.attack.Attack;
import model.attack.AttackPattern;

//classe métier Personnage
public abstract class Personnage extends Entite {
    //multiplie les dégats des attaques
    private int atkPnt;
    //points de vie maximums
    private int maxHP;
    //points de vie actuels
    private IntegerProperty currentHP = new SimpleIntegerProperty();
    //vitesse de déplacement
    private int speed;
    //description de l'attaque à instancier quand il tire
    private AttackPattern attaque;

    public Personnage(int atkPnt, int maxHP, int currentHP, int speed, int xsize, int ysize, int xpos, int ypos, String id, int redColor, int greenColor, int blueColor) {
        super(xsize,ysize,xpos,ypos, id);
        this.atkPnt = atkPnt;
        this.maxHP = maxHP;
        setCurrentHP(currentHP);
        this.speed = speed;
    }

    public int getAtkPnt() {
        return atkPnt;
    }

    public void setAtkPnt(int atkPnt) {
        this.atkPnt = atkPnt;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP.get();
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP.set(currentHP);
    }

    public IntegerProperty currentHPProperty() {
        return currentHP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toString(){
        return "atk : "+atkPnt+", max hp : "+maxHP+", current hp : "+currentHP+", speed : "+speed;
    }

    public void setAttaque(AttackPattern attaque) {
        this.attaque = attaque;
    }

    public AttackPattern getAttaque() {
        return attaque;
    }

}
