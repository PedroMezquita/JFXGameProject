package model;
import model.*;
import javafx.application.Platform;

public class BeepObserver implements Observer{

    @Override
    public void update () {
        Platform.runLater(()->{});
    }
}
