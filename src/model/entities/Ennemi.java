package model.entities;

import model.deplacement.Direction;

import java.util.LinkedList;

public abstract class Ennemi extends Personnage { //classe abstraite pour faire un point d'extensibilité

    private LinkedList<Direction> pattern = new LinkedList<>();
    private int isMoving = 0;

    public Ennemi(int atkPnt, int magPnt, int maxHP, int maxMana, int currentHP, int currentMana, int speed) { //constructeur pour pouvoir mieux instancier les prochaines classes
        super(atkPnt, magPnt, maxHP, maxMana, currentHP, currentMana, speed);
    }
}
