package model.attack;

import model.Direction;
import model.entities.Personnage;
import model.attack.AttackPattern;

public class JoueurAttacker implements Attacker{

    @Override
    public Attack attack(Personnage pers, Direction dir) {
        if (dir.getyDir() == 1){
            System.out.println("bas");
            int atqXPos = pers.getPos().getxPos()+(pers.getxSize()/2)-(pers.getAttaque().getxSize()/2);
            int atqYPos = pers.getPos().getyPos()+pers.getySize()+1;
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getxSize(), pers.getAttaque().getySize(), pers.getAttaque().getId(), pers, dir,  0,0, 1);
        }
        if (dir.getyDir() == -1){
            System.out.println("haut");
            int atqXPos = pers.getPos().getxPos()+(pers.getxSize()/2)-(pers.getAttaque().getxSize()/2);
            int atqYPos = pers.getPos().getyPos()-pers.getAttaque().getySize()-1;
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getxSize(), pers.getAttaque().getySize(), pers.getAttaque().getId(), pers, dir, 0,0, 1);
        }
        if (dir.getxDir() == -1){
            System.out.println("gauche");
            int atqXPos = pers.getPos().getxPos()-pers.getAttaque().getySize()-1;
            int atqYPos = pers.getPos().getyPos()+(pers.getySize()/2)-(pers.getAttaque().getxSize()/2);
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getySize(), pers.getAttaque().getxSize(), pers.getAttaque().getId(), pers, dir,  0,0, 1);
        }
        if (dir.getxDir() == 1){
            System.out.println("droite");
            int atqXPos = pers.getPos().getxPos()+pers.getxSize()+1;
            int atqYPos = pers.getPos().getyPos()+(pers.getySize()/2)-(pers.getAttaque().getxSize()/2);
            System.out.println(pers.getAttaque().getDegats());
            System.out.println(pers.getAtkPnt());
            return new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getySize(), pers.getAttaque().getxSize(), pers.getAttaque().getId(), pers, dir,  0,0, 1);
        }
        return null;
    }

}
