package model.collisions;

import model.Direction;
import model.entities.Entite;
import model.maps.Map;
import model.entities.Personnage;

public class CollisioneurCarre implements Collisioneur {
//faudra réussir à en faire un pour les ronds, je m'en occupe, fait marcher la boucle stp
    Map map;

    public CollisioneurCarre(Map map){
        this.map = map;
    }

    //On gère les collisions avec la position minimum du props et la maximum (position + taille) dans les deux axes.
    //On fait la même en prenant le déplacement en compte pour le personnage

    @Override
    public int testCollision(Personnage pers, Direction dir) {
        //calcul de la hitbox du personnage
        int persMinY = pers.getPos().getyPos()+(dir.getyDir()*pers.getSpeed()), persMaxY = pers.getPos().getyPos()+pers.getySize()+(dir.getyDir()*pers.getSpeed()), persMinX = pers.getPos().getxPos()+(dir.getxDir()*pers.getSpeed()), persMaxX = pers.getPos().getxPos()+pers.getxSize()+(dir.getxDir()*pers.getSpeed());
        //pour chaque entite de la map
        for (Entite entity : this.map.getAllEntities()) {
            //on calcule sa "hitbox"
            int minY = entity.getPos().getyPos(), maxY = entity.getPos().getyPos()+entity.getySize(), minX = entity.getPos().getxPos(), maxX = entity.getPos().getxPos()+entity.getxSize();
            //si ((le y minimum/maximum du joueur est compris entre les y du props)ou(le y du personnage englobe les y du props))et id du perso != id du props
            if (((persMinY >= minY && persMinY <= maxY) || (persMaxY >= minY && persMaxY <= maxY) || (persMaxY >= maxY && persMinY <= minY)) && entity.getId() != pers.getId()){
                //la même avec le X
                if (((persMinX >= minX && persMinX <= maxX) || (persMaxX >= minX && persMaxX <= maxX) || (persMaxX >= maxX && persMinX <= minX)) && entity.getId() != pers.getId()){
                    return 0;
                }
            }
        }
        return 1;
    }



    /*
    public void ajoutObstacle(Shape obst){
        obstacle.add(obst);
    }
*/
    /*
    //TEST, a supprimer une fois terminé
    public boolean testCollisionsCercle(Shape cercle, Personnage joueur){ //Sharp pour avoir la taille, Personnage pour la position, c'est un test
        Bounds shapeBound = cercle.getLayoutBounds(); //On garde la hitbox dans bounds
        Position pos = joueur.getPos(); //On garde la position dans pos
        for (Shape block : obstacle) { //Pour chaque obstacle
            Bounds bound = block.getLayoutBounds(); //Hitbox d'obstacle
            if ( (pos.getxPos()+shapeBound.getMaxX()) >= (bound.getCenterX()+bound.getMaxX()) && (pos.getyPos()+shapeBound.getMaxY()) >= (bound.getCenterY()+bound.getMaxY()) ){ //Si ça collisionne
                return true;
            }

        }
        return false; //Si rien collisionne
    }
     */
}

