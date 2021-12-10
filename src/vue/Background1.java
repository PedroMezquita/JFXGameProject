package vue;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import model.deplacement.Direction;
import model.entities.Position;

public class Background1 {

    @FXML
    private Circle cercle;

    @FXML
    public Circle getCercle(){
        return cercle;
    }

    @FXML
    public void setCercle(Position pos){
        cercle.setTranslateX(pos.getxPos());
        cercle.setTranslateY(pos.getyPos());
    }

}
