package vue;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.deplacement.Direction;
import model.entities.Entite;
import model.entities.Position;
import launch.Launcher;
import model.maps.Map;

public class Background1 {

    public void initialize(){
    }

    public void updateMap(Map map){
        for (Entite entity : map.getAllEntities()) {
            Rectangle rec = new Rectangle();
            rec.setX(entity.getPos().getxPos());
            rec.setY(entity.getPos().getyPos());
            rec.setHeight(entity.getxSize());
            rec.setWidth(entity.getySize());
            rec.setId(entity.getId());
            //Launcher.getStage().getScene().getRoot().getChildrenUnmodifiable().add(rec);
        }
    }
}
