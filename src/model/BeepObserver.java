package model;
import launch.Launcher;
import javafx.application.Platform;

public class BeepObserver implements Observer{

    @Override
    public void update () {
        Platform.runLater(()->{
            //Launcher.
        });
    }
}
