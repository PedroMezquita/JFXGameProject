package data;

import model.maps.Map;
import model.maps.TestMap;

public class Niveau5 extends Niveau{

    @Override
    public Map load() {
        Map map = new TestMap();
        return map;
    }
}
