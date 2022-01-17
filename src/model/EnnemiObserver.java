package model;

import javafx.application.Platform;

public class EnnemiObserver implements Observer{

    Manager manager;

    public EnnemiObserver (Manager manager){
        this.manager = manager;
    }

    @Override
    public void update() {
        Platform.runLater(()->{
            manager.updateEnemi();
        });
    }
}
