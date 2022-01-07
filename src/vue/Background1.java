package vue;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.deplacement.Direction;
import model.entities.Entite;
import model.entities.Position;
import launch.Launcher;
import model.maps.Map;
import model.entities.Props;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Background1 {

    @FXML
    public Circle EnnemiIGuess = new Circle();

    @FXML
    private Group groupe = new Group();


    public void initialize() {
        ajoutEnnemi();
    }


    @FXML
    public void ajoutEnnemi(){
        EnnemiIGuess.setId("enem1");
        EnnemiIGuess.setCenterX(0);
        EnnemiIGuess.setCenterY(0);
        groupe.getChildren().addAll(EnnemiIGuess);
    }


    @FXML
    public void visualiserMap(Map map){
    }


    @FXML
    public void updateMap(Map map){

        for (Entite entity : map.getAllEntities()) {
            Rectangle rec = new Rectangle();
            rec.setX(entity.getPos().getxPos());
            rec.setY(entity.getPos().getyPos());
            rec.setHeight(entity.getxSize());
            rec.setWidth(entity.getySize());
            rec.setId(entity.getId());
            //Launcher.getStage().getScene().getRoot().getChildrenUnmodifiable().add(rec);
        }
    }

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


    @FXML
    public Direction detectDirection(Direction dir){
        System.out.println("direction");
        Stage stage = Launcher.getStage();
        Scene sc = stage.getScene();
        sc.setOnKeyPressed((EventHandler) event -> {


        });

        return (Direction) null;
    }




}
