package vue;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.util.converter.NumberStringConverter;
import model.Manager;
import model.entities.*;
import launch.Launcher;
import model.maps.Map;
import model.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javafx.scene.control.Button;

public class Background1 {
/*
    @FXML
    public Circle EnnemiIGuess;

    @FXML
    private Group groupe;
*/
    @FXML
    private Pane ecran;

    private static Manager manager = new Manager();


    public void initialize() {
        //updateMap(manager.getMap());
        /*
        manager.getJoueur().getPos().xPosProperty().addListener(xProperty -> {
        //    Rectangle rec = (Rectangle) Launcher.getStage().getScene().lookup(Launcher.getManager().getJoueur().getId());

            Rectangle rec = (Rectangle) ecran.getChildren().get(0); //vu que la position du joueur dans le stub est 0 il sera toujours en tete de liste et donc ajouté en premier
            rec.setX(manager.getJoueur().getPos().getxPos());
        });
        manager.getJoueur().getPos().yPosProperty().addListener(yProperty -> {
        //    Rectangle rec = (Rectangle) Launcher.getStage().getScene().lookup(Launcher.getManager().getJoueur().getId());//Launcher.getManager().getJoueur().getId() Donne "joueur", getName() = "mec"

            Rectangle rec = (Rectangle) ecran.getChildren().get(0); //vu que la position du joueur dans le stub est 0 il sera toujours en tete de liste et donc ajouté en premier
            rec.setY(manager.getJoueur().getPos().getyPos()); //Il detecte les positions inverses
        });
        */
        //perso = new Rectangle(manager.getJoueur().getxSize(), manager.getJoueur().getySize());
        //ecran.getChildren().add(perso);

        ecran.setPrefWidth(500);
        ecran.setPrefHeight(500);
        ecran.setMinHeight(500);
        ecran.setMinWidth(500);

//POINTS
        /*
        manager.getMap().nbEnnemisProperty().addListener(nbEnemis ->{
            manager.setPoints(manager.getPoints()+1);

        });
//POINTS

         */
        ecran.widthProperty().addListener(largeur -> {manager.getMap().setWidth((int) ecran.getWidth());});
        ecran.heightProperty().addListener(largeur -> {manager.getMap().setHeight((int) ecran.getHeight());});
        Launcher.getStage().addEventFilter(KeyEvent.KEY_PRESSED, Event -> {manager.addTouche(Event.getCode());});
        Launcher.getStage().addEventFilter(KeyEvent.KEY_RELEASED, Event -> {manager.removeTouche(Event.getCode());});
        setUp();

    }

    public void setUp (){
        updateMap(manager.getMap());
        manager.getMap().nbEntiteProperty().addListener(nbEntite ->{updateMap(manager.getMap());});

        manager.getJoueur().currentHPProperty().addListener(pv -> {
            if (manager.getJoueur().getCurrentHP() <= 0) {
                //manager.stopBoucle();
                Text txt = new Text("GAME OVER");
                txt.setTextAlignment(TextAlignment.CENTER);
                ecran.getChildren().add(txt);
                txt.setX(ecran.getWidth() / 2);
                txt.setY(ecran.getHeight() / 2);
            }
        });
        manager.getMap().nbEnnemisProperty().addListener(nbEnemis -> {  if(manager.getMap().getNbEnnemis() <= 0){
            //manager.stopBoucle();
            if(manager.niveauSuivant()) {
                updateMap(manager.getMap());
                //manager.startBoucle();
            }
            else{
                Text txt = new Text("Victoire : vous avez fini le jeu");
                txt.setTextAlignment(TextAlignment.CENTER);
                ecran.getChildren().add(txt);
                txt.setX(150);
                txt.setY(200);
                setButtons();
            }
        }
        });
    }



            /*
            //POINTS

            TextField txt = new TextField();
            txt.textProperty().bindBidirectional(manager.getPointsProperty(), new NumberStringConverter());
            ecran.getChildren().add(txt);
            //POINTS

             */


    public void loadEntity(Entite entity){
        if (entity.getSprite() != null) {
            String url = entity.getSprite();
            ImageView img = new ImageView(new Image(url));
            img.layoutXProperty().bind(entity.getPos().xPosProperty());
            img.layoutYProperty().bind(entity.getPos().yPosProperty());
            img.setFitHeight(entity.getySize());
            img.setFitWidth(entity.getxSize());
            img.setId(entity.getId());
            ecran.getChildren().add(img);
        }
        else {
            Rectangle rec = new Rectangle();
            rec.layoutXProperty().bind(entity.getPos().xPosProperty());
            rec.layoutYProperty().bind(entity.getPos().yPosProperty());
            rec.setFill(Color.color((float) entity.getRedColor(),(float) entity.getGreenColor(),(float) entity.getBlueColor()));
            rec.setHeight(entity.getySize());
            rec.setWidth(entity.getxSize());
            rec.setId(entity.getId());
            ecran.getChildren().add(rec);
        }
        Image img = new Image("TemplateBackground.png");
        BackgroundImage backImg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background back = new Background(backImg);
        ecran.setBackground(back);
    }

    public void updateMap (Map map){
        for (Entite entity : map.getRemovedEntities()) {
            ecran.getChildren().remove(ecran.lookup("#"+entity.getId()));
            map.eraseEntity(entity);
        }
        for (Entite entite : map.getNewEntities()){
            loadEntity(entite);
            map.handleEntity(entite);
        }
    }

    public void setButtons (){
        Button restart = new Button("recommencer");
        restart.setOnAction(restartFire -> {
            recommencer();
        });
        ecran.getChildren().add(restart);
        restart.setLayoutX(150);
        restart.setLayoutY(250);
    }

    public void recommencer (){
        manager.stopBoucle();
        manager.init();
        ecran.getChildren().removeAll(ecran.getChildren());
        setUp();
        //manager.startBoucle();
    }


    //on rajoute pas des trucs dans le modèle depuis la vue.
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
