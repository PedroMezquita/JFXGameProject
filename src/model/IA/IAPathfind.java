package model.IA;

import com.sun.nio.sctp.SendFailedNotification;
import model.Direction;
import model.attack.Attack;
import model.attack.BasiqueAttacker;
import model.collisions.CollisioneurVisionEnnemi;
import model.deplacement.DeplacerEnnemie;
import model.deplacement.Deplaceur;
import model.entities.Ennemi;
import model.entities.Entite;
import model.entities.Joueur;
import model.entities.Personnage;
import model.maps.Map;

public class IAPathfind implements IA{
    @Override
    public Direction approcheJoueur(Personnage joueur, Personnage enemi, Map map) {
        Direction path = new Direction(0,0);
        if (joueur.getPos().getxPos()+joueur.getxSize()/2 < enemi.getPos().getxPos()+enemi.getxSize()/2) {
            path.setxDir(-1);
        }
        else if (joueur.getPos().getxPos()+joueur.getxSize()/2 > enemi.getPos().getxPos()+enemi.getxSize()/2){
            path.setxDir(1);
        }
        if (joueur.getPos().getyPos()+joueur.getySize()/2 < enemi.getPos().getyPos()+enemi.getySize()/2){
            path.setyDir(-1);
        }
        else if (joueur.getPos().getyPos()+joueur.getySize()/2 > enemi.getPos().getyPos()+enemi.getySize()/2){
            path.setyDir(1);
        }

        Direction dir = new Direction(0,0);
        if(new CollisioneurVisionEnnemi(map).testCollision(enemi,dir)){
            BasiqueAttacker atker = new BasiqueAttacker();
            dir.setyDir(path.getyDir()*dir.getyDir());
            dir.setxDir(path.getxDir()*dir.getxDir());
            Attack atk = atker.attack(enemi,dir);
            if (atk != null)
                map.addAttack(atk);
        }


        return path;
    }
}

