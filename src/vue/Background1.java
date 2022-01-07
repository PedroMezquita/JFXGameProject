package vue;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.deplacement.Direction;
import model.entities.*;
import launch.Launcher;
import model.maps.Map;
import model.maps.TestMap;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Background1 {
/*
    @FXML
    public Circle EnnemiIGuess;

    @FXML
    private Group groupe;
*/
    @FXML
    private Pane ecran;


    public void initialize() {
        updateMap(Launcher.getManager().getMap());
        //ecran.setOnKeyPressed(keyEvent -> {Launcher.getManager().addTouche(keyEvent.getCode());});
    }

//pas touche à l'id css
    /*
    @FXML
    public void ajoutEnnemi(){
        EnnemiIGuess.setId("enem1");
        EnnemiIGuess.setCenterX(0);
        EnnemiIGuess.setCenterY(0);
        groupe.getChildren().addAll(EnnemiIGuess);
    }
*/

    @FXML
    public void visualiserMap(Map map){
    }


    @FXML
    public void updateMap(Map map){

        for (Entite entity : map.getAllEntities()) {
            Rectangle rec = new Rectangle();
            ecran.getChildren().add(rec);
            rec.setX(entity.getPos().getxPos());
            rec.setY(entity.getPos().getyPos());
            rec.setHeight(entity.getySize());
            rec.setWidth(entity.getxSize());
            rec.setId(entity.getId());
        }
    }

    //on rajoute pas des trucs dans le modèle depuis la vue.
    /*
    @FXML
    public ArrayList<Entite> ajouterObstacles(){
        Rectangle obst1 = (Rectangle) Launcher.getStage().getScene().getRoot().lookup("#murTop");
        Props obstacle1 = new Props(obst1.getScaleX(),obst1.getScaleY(),obst1.getX(),obst1.getY(), obst1.getId());
        obst1.setHeight(obstacle1.getySize()); //hauteur = y, largeur = x
        obst1.setWidth(obstacle1.getxSize());
        obst1.setX(obstacle1.getPos().getxPos());
        obst1.setY(obstacle1.getPos().getyPos());

        ArrayList<Entite> AllProps = new ArrayList<Entite>();
        AllProps.add(obstacle1);

        return AllProps;
    }
    */
/*
    @FXML
    public Direction detectDirection(Direction dir){
        System.out.println("direction");
        Stage stage = Launcher.getStage();
        Scene sc = stage.getScene();
        sc.setOnKeyPressed((EventHandler) event -> {


        });

        return (Direction) null;
    }
*/



}
