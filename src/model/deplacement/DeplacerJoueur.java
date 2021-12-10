package model.deplacement;

import model.entities.Personnage;

public class DeplacerJoueur implements Deplaceur {
    @Override
    public void deplacer(Personnage pers, Direction dir) {
        int verticalMvmt = dir.getxDir()*pers.getSpeed();
        int horizontalMvmt = dir.getyDir()*pers.getSpeed();
        pers.setPosition(pers.getPos().getxPos()+verticalMvmt,pers.getPos().getyPos()+horizontalMvmt);
    }
    //Aussi statique, on ne pourra pas instancier un deplaceur a chaque fois qu'on veut jouer, en tout cas pseudocode a revoir (a la place d'instancier position a chaque fois vaut mieux juste modifier les valeurs)
}
