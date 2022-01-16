package model.collisions;

import model.Direction;
import model.attack.Attack;
import model.attack.Attacker;
import model.attack.EnnemiAttacker;
import model.attack.JoueurAttacker;
import model.entities.Entite;
import model.entities.Personnage;
import model.maps.Map;

public class CollisioneurEnnemi implements CollisioneurMouvement{

    Map map;

    public CollisioneurEnnemi(Map map){
        this.map = map;
    }


    @Override
    public int testCollision(Personnage pers, Direction dir) {
        int persMinY = pers.getPos().getyPos()+(dir.getyDir()*pers.getSpeed()), persMaxY = pers.getPos().getyPos()+pers.getySize()+(dir.getyDir()*pers.getSpeed()), persMinX = pers.getPos().getxPos()+(dir.getxDir()*pers.getSpeed()), persMaxX = pers.getPos().getxPos()+pers.getxSize()+(dir.getxDir()*pers.getSpeed());
        //on trouve le joueur dans la mape
        Personnage entity = map.getJoueur();
            if (!map.getAllAttacks().contains(entity)) {
                int minY = entity.getPos().getyPos(), maxY = entity.getPos().getyPos() + entity.getySize(), minX = entity.getPos().getxPos(), maxX = entity.getPos().getxPos() + entity.getxSize();
                //si ((le y minimum/maximum du joueur est compris entre les y du props)ou(le y du personnage englobe les y du props))et id du perso != id du props
                if (((persMinY >= minY && persMinY <= maxY) || (persMaxY >= minY && persMaxY <= maxY) || (persMaxY >= maxY && persMinY <= minY)) && entity.getId() != pers.getId()) {
                    //la même avec le X
                    if (((persMinX >= minX && persMinX <= maxX) || (persMaxX >= minX && persMaxX <= maxX) || (persMaxX >= maxX && persMinX <= minX)) && entity.getId() != pers.getId()) {
                        Attacker atk = new EnnemiAttacker();
                        Attack atack = atk.attack(pers, dir);
                        pers.setCurrentAttack(atack);
                        map.addEntity(atack);
                        return 0;
                    }
                }
            }
        return 1;
    }
}
