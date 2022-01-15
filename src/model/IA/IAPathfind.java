package model.IA;

import com.sun.nio.sctp.SendFailedNotification;
import model.Direction;
import model.deplacement.DeplacerEnnemie;
import model.deplacement.Deplaceur;
import model.entities.Entite;
import model.entities.Personnage;

public class IAPathfind implements IA{
    @Override
    public Direction approcheJoueur(Personnage joueur, Personnage enemi) {
        Direction path = new Direction(0,0);
        if (joueur.getPos().getxPos() < enemi.getPos().getxPos()) {
            path.setxDir(-1);
        }
        else if (joueur.getPos().getxPos() > enemi.getPos().getxPos()){
            path.setxDir(1);
        }
        if (joueur.getPos().getyPos() < enemi.getPos().getyPos()){
            path.setyDir(-1);
        }
        else if (joueur.getPos().getyPos() > enemi.getPos().getyPos()){
            path.setyDir(1);
        }

        return path;
    }
}
