package model.attack;

import model.Direction;
import model.entities.Position;

public class AtkDeplaceurSimple implements AtkDeplaceur{

    //Ce serais une bonne idée d'avoir une vitesse d'attaque pour ça, en tout cas je le laisse a 10 ça devrais le faire
    //Tirer a droite ou en bas ne fait aucune influence dans le collisionneur mais tirer en haut ou a gauche ça empeche le joueur de se deplacer dans cette direction (enfait ça ne marche que la moitie des fois)
    public void deplaceAttack(Attack atk){
        Direction dir = atk.getDir();
        Position oldPos = atk.getPos();
        if(dir.getyDir() == -1){
            atk.setPosition(oldPos.getxPos(), oldPos.getyPos()-10);
        }
        if(dir.getyDir() == 1){
            atk.setPosition(oldPos.getxPos(), oldPos.getyPos()+10);
        }
        if(dir.getxDir() == -1){
            atk.setPosition(oldPos.getxPos()-10, oldPos.getyPos());
        }
        if(dir.getxDir() == 1){
            atk.setPosition(oldPos.getxPos()+10, oldPos.getyPos());
        }
    }

}
