package model.entities;

public class Guerrier extends Joueur {
//nom bougé dans Joueur
    public Guerrier(int atkPnt, int magPnt, int maxHP, int maxMana, int currentHP, int currentMana, int speed, String name, int xsize, int ysize, int xpos, int ypos, int id) {
        super(atkPnt, magPnt, maxHP, maxMana, currentHP, currentMana, speed, name, xsize, ysize, xpos, ypos, id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
