package model.attack;

import model.maps.Map;

public class AtkUpdater {

    public void updateAttack(Map map){

        for (Attack atk : map.getAllAttacks()) {
            atk.setLifeTime(atk.getLifeTime()-1);
            if (atk.getLifeTime() == 0){
                map.removeAttack(atk);
                atk.getPerso().setCurrentAttack(null);
            }
        }
    }

}
