package model.attack;

import model.Direction;
import model.collisions.CollisioneurAttaque;
import model.collisions.CollisioneurAttaqueEnnemi;
import model.collisions.CollisioneurAttaqueJoueur;
import model.entities.Position;
import model.maps.Map;

public class AtkUpdater {

    private CollisioneurAttaque colAtk = new CollisioneurAttaqueEnnemi();
    private CollisioneurAttaqueJoueur colAtkJoueur = new CollisioneurAttaqueJoueur();

    public void updateAttack(Map map){

        for (Attack atk : map.getAllAttacks()) {
            atk.setLifeTime(atk.getLifeTime()-1);
            if (atk.getLifeTime() == 0){
                map.removeAttack(atk);
                atk.getPerso().setCurrentAttack(null);
            }else{
                AtkDeplaceur deplaceur = new AtkDeplaceurSimple();
                deplaceur.deplaceAttack(atk);
                colAtk.hitTest(atk, map);
                colAtkJoueur.hitTest(atk, map);
            }
        }
    }

}
