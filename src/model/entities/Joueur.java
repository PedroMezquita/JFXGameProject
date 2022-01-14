package model.entities;

public class Joueur extends Personnage { //point d'extensibilité

    private String name; //Nom du personnage

    public Joueur(int atkPnt, int magPnt, int maxHP, int maxMana, int currentHP, int currentMana, int speed, String name, int xsize, int ysize, int xpos, int ypos, String id, int redColor, int greenColor, int blueColor) {
        super(atkPnt, magPnt, maxHP, maxMana, currentHP, currentMana, speed, xsize, ysize, xpos, ypos, id, redColor, greenColor, blueColor);
        this.name = name;
    }

    @Override
    public String toString() {
        return "nom : "+name+", "+super.toString();
    }

    public String getName() {
        return name;
    }
}
