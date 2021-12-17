package model.deplacement;

import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import model.entities.Joueur;
import model.entities.Position;
import model.maps.Map;
import model.entities.Personnage;

import javax.print.attribute.standard.JobStateReason;
import java.util.ArrayList;

public class CollisioneurBase implements Collisioneur{

    private ArrayList<Shape> obstacle = new ArrayList(); //Liste des obstacles (changer shape une fois tout sera bien codé)

    @Override
    public boolean testCollision(Personnage pers, Direction dir, Map map) {
        //Ceci est un code temporaire pour tester les collisions avant les implementer, forte chance que ça ne marche pas

        return false;
    }


    public void ajoutObstacle(Shape obst){
        obstacle.add(obst);
    }

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
}

