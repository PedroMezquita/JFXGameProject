package model.IA;

import model.Direction;
import model.entities.Entite;
import model.entities.Personnage;

public interface IA {

    public Direction approcheJoueur(Personnage joueur, Personnage enemi);
}
