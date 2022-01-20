package model.collisions;

import model.Direction;
import model.entities.Personnage;
import model.maps.Map;

//sert à tester si un ennemi a le joueur dans une direction cardinale pour tirer
public class CollisioneurVisionEnnemi implements CollisioneurMouvement{

    //contient toutes les entiées dont le joueur
    Map map;

    public CollisioneurVisionEnnemi(Map map){
        this.map = map;
    }


    @Override
    public boolean testCollision(Personnage pers, Direction dir) {
        int persMinY = pers.getPos().getyPos()+pers.getySize()/2+pers.getAttaque().getySize()/2, persMaxY = pers.getPos().getyPos()+pers.getySize()/2-pers.getAttaque().getySize()/2, persMinX = pers.getPos().getxPos()+pers.getxSize()/2-pers.getAttaque().getxSize()/2, persMaxX = pers.getPos().getxPos()+pers.getxSize()/2+pers.getAttaque().getxSize()/2;
        //on trouve le joueur dans la map
        Personnage joueur = map.getJoueur();
        //Si la partie est finie les ennemis ne doivent plus bouger
        if (joueur == null) {return true;}
        //calcul de la hitbox du joueur
        int minY = joueur.getPos().getyPos(), maxY = joueur.getPos().getyPos() + joueur.getySize(), minX = joueur.getPos().getxPos(), maxX = joueur.getPos().getxPos() + joueur.getxSize();
                //si ((le y minimum/maximum du joueur est compris entre les y du perso)ou(le y du personnage englobe les y du joueur))et id du perso != id du joueur
        if (((persMinY >= minY && persMinY <= maxY) || (persMaxY >= minY && persMaxY <= maxY) || (persMaxY >= maxY && persMinY <= minY)) && joueur.getId() != pers.getId()) {
            dir.setxDir(1);
            return true;
        }
        //même chose avec le x
        else if (((persMinX >= minX && persMinX <= maxX) || (persMaxX >= minX && persMaxX <= maxX) || (persMaxX >= maxX && persMinX <= minX)) && joueur.getId() != pers.getId()) {
            dir.setyDir(1);
            return true;
        }

        return false;
    }
}
