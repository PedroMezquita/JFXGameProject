package model.IA;

import model.Direction;
import model.entities.Personnage;
import model.maps.Map;

//interface qui définie la méthode de déplacement des ennemis
public interface IA {
    //déplace un ennemi en direction du joueur et retourne la direction choisie
    Direction approcheJoueur(Personnage joueur, Personnage enemi, Map map);
}
