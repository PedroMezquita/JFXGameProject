package vue;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import model.deplacement.Direction;

public class Background1 {

    @FXML
    private Circle cercle;

    public void initialize(){
        Direction dir = new Direction(0,0);
    }

    @FXML
    public Circle getCercle(){
        return cercle;
    }



}
