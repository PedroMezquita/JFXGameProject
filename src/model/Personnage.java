package model;

public class Personnage extends Entite{
    private int atkPnt;
    private int magPnt;
    private int maxHP;
    private int maxMana;
    private int currentHP;
    private int currentMana;
    private int speed;

    public Personnage(int atkPnt, int magPnt, int maxHP, int maxMana, int currentHP, int currentMana, int speed) {
        this.atkPnt = atkPnt;
        this.magPnt = magPnt;
        this.maxHP = maxHP;
        this.maxMana = maxMana;
        this.currentHP = currentHP;
        this.currentMana = currentMana;
        this.speed = speed;
    }

    public int getAtkPnt() {
        return atkPnt;
    }

    public void setAtkPnt(int atkPnt) {
        this.atkPnt = atkPnt;
    }

    public int getMagPnt() {
        return magPnt;
    }

    public void setMagPnt(int magPnt) {
        this.magPnt = magPnt;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
