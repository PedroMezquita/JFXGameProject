package model;

import javafx.application.Platform;

public class GameOverObserver implements Observer{

    private Manager manager;

    public GameOverObserver(Manager manager){this.manager = manager;}

    @Override
    public void update() {
        Platform.runLater(() -> {
            if(manager.getJoueur().getCurrentHP() == 0){
                manager.gameOver();
            }
        });
    }
}
