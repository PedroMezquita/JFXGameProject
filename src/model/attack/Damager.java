package model.attack;

import model.entities.Ennemi;
import model.maps.Map;

import java.util.ArrayList;

public interface Damager {

    void enemiHit(Attack atk, ArrayList<Ennemi> hits, Map map);

}
