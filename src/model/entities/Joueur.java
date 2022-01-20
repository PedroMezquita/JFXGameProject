package model.entities;

//classe métier Joueur
public class Joueur extends Personnage {

    //Nom du personnage
    private String name;

    public Joueur(int atkPnt, int maxHP, int currentHP, int speed, String name, int xsize, int ysize, int xpos, int ypos, String id, int redColor, int greenColor, int blueColor) {
        super(atkPnt, maxHP, currentHP, speed, xsize, ysize, xpos, ypos, id, redColor, greenColor, blueColor);
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
