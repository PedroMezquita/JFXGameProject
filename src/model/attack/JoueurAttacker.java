package model.attack;

import model.Direction;
import model.entities.Personnage;
import model.attack.AttackPattern;

public class JoueurAttacker implements Attacker{

    @Override
    public Attack attack(Personnage pers, Direction dir) {
        if (dir.getyDir() == 1){
            System.out.println("bas");
            int atqXPos = pers.getPos().getxPos()+pers.getxSize()/2-pers.getAttaque().getxSize()/2;
            int atqYPos = pers.getPos().getyPos()-pers.getySize();
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats(), atqXPos, atqYPos, pers.getAttaque().getxSize(), pers.getAttaque().getySize(), pers.getAttaque().getId());
        }
        if (dir.getyDir() == -1){
            System.out.println("haut");
            int atqXPos = pers.getPos().getxPos()+pers.getxSize()/2-pers.getAttaque().getxSize()/2;
            int atqYPos = pers.getPos().getyPos()+pers.getAttaque().getySize();
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats(), atqXPos, atqYPos, pers.getAttaque().getxSize(), pers.getAttaque().getySize(), pers.getAttaque().getId());
        }
        if (dir.getxDir() == -1){
            System.out.println("gauche");
            int atqXPos = pers.getPos().getxPos()-pers.getAttaque().getySize();
            int atqYPos = pers.getPos().getyPos()-pers.getySize()/2+pers.getAttaque().getxSize()/2;
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats(), atqXPos, atqYPos, pers.getAttaque().getySize(), pers.getAttaque().getxSize(), pers.getAttaque().getId());
        }
        if (dir.getxDir() == 1){
            System.out.println("droite");
            int atqXPos = pers.getPos().getxPos()+pers.getxSize();
            int atqYPos = pers.getPos().getyPos()-pers.getySize()/2+pers.getAttaque().getxSize()/2;
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats(), atqXPos, atqYPos, pers.getAttaque().getySize(), pers.getAttaque().getxSize(), pers.getAttaque().getId());
        }
        return null;
    }

}
