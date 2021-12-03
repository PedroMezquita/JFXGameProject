package model;

public class Guerrier extends Personnage{

    private String name; //Nom du personnage


    public Guerrier(int atkPnt, int magPnt, int maxHP, int maxMana, int currentHP, int currentMana, int speed, String name) {
        super(atkPnt, magPnt, maxHP, maxMana, currentHP, currentMana, speed);
        this.name = name;
    }
}
