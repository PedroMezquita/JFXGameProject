package model.deplacement;

import model.Direction;
import model.collisions.CollisioneurMouvement;
import model.collisions.CollisioneurMouvement;
import model.entities.Personnage;

public class DeplacerBasique implements Deplaceur {

    CollisioneurMouvement col;

    public DeplacerBasique(CollisioneurMouvement col) {
        this.col = col;
    }

    @Override
    public void deplacer(Personnage pers, Direction dir) {
        if (col.testCollision(pers, dir) || pers.getSpeed() == 0) {
            int verticalMvmt = dir.getxDir() * pers.getSpeed();
            int horizontalMvmt = dir.getyDir() * pers.getSpeed();
            pers.setPosition(pers.getPos().getxPos() + verticalMvmt, pers.getPos().getyPos() + horizontalMvmt);
        }
        else {
                int tmpSpeed = pers.getSpeed();
                //récursivité qui permet de se coller au mur histoire de rendre le déplacement moins galère pour le joueur
                if (tmpSpeed > 0) {
                    pers.setSpeed(tmpSpeed - 1);
                }
                else {
                    pers.setSpeed(tmpSpeed + 1);
                }
                deplacer(pers, dir);
                pers.setSpeed(tmpSpeed);
        }
    }



}