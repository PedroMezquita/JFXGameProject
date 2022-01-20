package model.attack;

import model.collisions.CollisioneurAttaque;
import model.collisions.CollisioneurAttaqueEnnemi;
import model.collisions.CollisioneurAttaqueJoueur;
import model.maps.Map;

//classe qui met à jour les attaque
public class AtkUpdater {

    //sert afin de déterminer si une attaque ennemie à touchée
    private CollisioneurAttaque colAtk = new CollisioneurAttaqueEnnemi();
    //sert afin de déterminer si une attaque du joueur à touchée un ennemi
    private CollisioneurAttaqueJoueur colAtkJoueur = new CollisioneurAttaqueJoueur();

    //met à jour le temps de vie des attaques et les déplaces si elles ne disparaissent pas. appel aussi des collisionneurs pour tester si elles touches.
    public void updateAttack(Map map){

        for (Attack atk : map.getAllAttacks()) {
            atk.setLifeTime(atk.getLifeTime()-1);
            //si le temps de vie de l'attaque est écoulé
            if (atk.getLifeTime() == 0){
                map.removeAttack(atk);
            }else{
                AtkDeplaceur deplaceur = new AtkDeplaceurSimple();
                deplaceur.deplaceAttack(atk);
                colAtk.hitTest(atk, map);
                colAtkJoueur.hitTest(atk, map);
            }
        }
    }

}
