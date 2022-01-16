package model.attack;

import model.entities.Personnage;
import model.maps.Map;

import java.util.ArrayList;

public interface DamagerEnnemi {
    public void personnageHit(Attack atk, ArrayList<Personnage> personnage , Map map);
}
