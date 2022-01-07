package model;

import javafx.application.Platform;

public class ObserverDeplacement implements Observer {

    @Override
    public void update (){
        Platform.runLater(()->{

        });
    }
}
