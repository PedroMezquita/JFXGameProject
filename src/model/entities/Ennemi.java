package model.entities;

import model.Direction;

import java.util.LinkedList;

public abstract class Ennemi extends Personnage { //classe abstraite pour faire un point d'extensibilité

    private LinkedList<Direction> pattern = new LinkedList<>();
    private int isMoving = 0;

    public Ennemi(int atkPnt, int magPnt, int maxHP, int maxMana, int currentHP, int currentMana, int speed, int xsize, int ysize, int xpos, int ypos, String id) {
        super(atkPnt, magPnt, maxHP, maxMana, currentHP, currentMana, speed, xsize, ysize, xpos, ypos, id);
    }
}
