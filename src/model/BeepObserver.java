package model;
import launch.Launcher;
import javafx.application.Platform;

public class BeepObserver implements Observer{

    @Override
    public void update () {
        Platform.runLater(()->{
            System.out.println(Launcher.getManager().getListeTouches());
            Launcher.getManager().readKeys();
            Launcher.getManager().resetListeTouches();
        });
    }
}