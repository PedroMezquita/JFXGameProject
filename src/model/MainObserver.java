package model;
import launch.Launcher;
import javafx.application.Platform;

public class MainObserver implements Observer{

    Manager manager;

    public MainObserver (Manager manager){
        this.manager = manager;
    }

    @Override
    public void update () {
        Platform.runLater(()->{
            System.out.println(manager.getListeTouches());
            manager.readKeys();
            manager.updateAttaque();
        });
    }
}
