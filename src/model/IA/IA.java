package model.IA;

import model.Direction;
import model.entities.Entite;
import model.entities.Personnage;
import model.maps.Map;

public interface IA {

    public Direction approcheJoueur(Personnage joueur, Personnage enemi, Map map);
}
