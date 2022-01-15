package model.deplacement;

import model.Direction;
import model.collisions.CollisioneurMouvement;
import model.entities.Personnage;

public class DeplacerEnnemie implements Deplaceur{

    CollisioneurMouvement col;

    public DeplacerEnnemie(CollisioneurMouvement col){ this.col = col;}

    @Override
    public void deplacer(Personnage pers, Direction dir) { //dir est la direction se raprochant le plus du joueur, à ensuite modifier avec le pattern de mouvement
        if(col.testCollision(pers, dir) == 1){
            int verticalMvmt = dir.getxDir() * pers.getSpeed();
            int horizontalMvmt = dir.getyDir() * pers.getSpeed();
            pers.setPosition(pers.getPos().getxPos() + verticalMvmt, pers.getPos().getyPos() + horizontalMvmt);
        }
        //Il faudrais trouver comment on peut detecter collision avec le joueur
        else{
            int tmpSpeed = pers.getSpeed();
            //récursivité qui permet de se coller au mur histoire de rendre le déplacement moins galère pour le joueur
            pers.setSpeed(tmpSpeed-1);
            deplacer(pers,dir);
            pers.setSpeed(tmpSpeed);
        }

    }


}
