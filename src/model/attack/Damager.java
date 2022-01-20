package model.attack;

import model.entities.Ennemi;
import model.maps.Map;

import java.util.ArrayList;

//interface de calcule des dégats des attaques du joueur
public interface Damager {

    //inflige les dégats de l'attaque à partir de l'attaque, d'une liste d'enemis touchés et les supprimes de la carte en cas de mort
    void enemiHit(Attack atk, ArrayList<Ennemi> hits, Map map);

}
