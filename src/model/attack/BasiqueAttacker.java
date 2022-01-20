package model.attack;

import model.Direction;
import model.entities.Personnage;
import model.attack.AttackPattern;
import model.maps.Map;

public class BasiqueAttacker implements Attacker{

    @Override
    public Attack attack(Personnage pers, Direction dir) {
        if (pers.getAttaque().getCurrentcooldown() > 0){
            return null;
        }
        pers.getAttaque().resetCooldown();
        if (dir.getyDir() == 1){
            System.out.println("bas");
            int atqXPos = pers.getPos().getxPos()+(pers.getxSize()/2)-(pers.getAttaque().getxSize()/2);
            int atqYPos = pers.getPos().getyPos()+pers.getySize()+1;
            Attack atk = new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getxSize(), pers.getAttaque().getySize(), pers.getAttaque().getId(), pers, dir);
            atk.setSprite(pers.getAttaque().getSprite());
            atk.setRGB(pers.getAttaque().getRedColor(),pers.getAttaque().getGreenColor(),pers.getAttaque().getBlueColor());
            return atk;
        }
        if (dir.getyDir() == -1){
            System.out.println("haut");
            int atqXPos = pers.getPos().getxPos()+(pers.getxSize()/2)-(pers.getAttaque().getxSize()/2);
            int atqYPos = pers.getPos().getyPos()-pers.getAttaque().getySize()-1;
            Attack atk = new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getxSize(), pers.getAttaque().getySize(), pers.getAttaque().getId(), pers, dir);
            atk.setSprite(pers.getAttaque().getSprite());
            atk.setRGB(pers.getAttaque().getRedColor(),pers.getAttaque().getGreenColor(),pers.getAttaque().getBlueColor());
            return atk;
        }
        if (dir.getxDir() == -1){
            System.out.println("gauche");
            int atqXPos = pers.getPos().getxPos()-pers.getAttaque().getySize()-1;
            int atqYPos = pers.getPos().getyPos()+(pers.getySize()/2)-(pers.getAttaque().getxSize()/2);
            Attack atk = new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getySize(), pers.getAttaque().getxSize(), pers.getAttaque().getId(), pers, dir);
            atk.setSprite(pers.getAttaque().getSprite());
            atk.setRGB(pers.getAttaque().getRedColor(),pers.getAttaque().getGreenColor(),pers.getAttaque().getBlueColor());
            return atk;
        }
        if (dir.getxDir() == 1){
            System.out.println("droite");
            int atqXPos = pers.getPos().getxPos()+pers.getxSize()+1;
            int atqYPos = pers.getPos().getyPos()+(pers.getySize()/2)-(pers.getAttaque().getxSize()/2);
            System.out.println(pers.getAttaque().getDegats());
            System.out.println(pers.getAtkPnt());
            Attack atk = new Attack(pers.getAttaque().getLifeTime(), pers.getAttaque().getDegats()*pers.getAtkPnt(), atqXPos, atqYPos, pers.getAttaque().getySize(), pers.getAttaque().getxSize(), pers.getAttaque().getId(), pers, dir);
            atk.setSprite(pers.getAttaque().getSprite());
            atk.setRGB(pers.getAttaque().getRedColor(),pers.getAttaque().getGreenColor(),pers.getAttaque().getBlueColor());
            return atk;
        }
        return null;
    }

}
