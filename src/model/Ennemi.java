package model;

public abstract class Ennemi extends Personnage{ //classe abstraite alors qu'on n'utilise pas des methodes abstraites

    public Ennemi(int atkPnt, int magPnt, int maxHP, int maxMana, int currentHP, int currentMana, int speed) { //constructeur pour pouvoir mieux instancier les prochaines classes
        super(atkPnt, magPnt, maxHP, maxMana, currentHP, currentMana, speed);
    }
}
