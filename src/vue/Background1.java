package vue;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
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

        updateMap(manager.getMap());
        manager.getMap().nbEntiteProperty().addListener(nbEntite ->{updateMap(manager.getMap());
                                                                    if(manager.getJoueur().getCurrentHP() <= 0){
                                                                        manager.getBeep().interrupt();
                                                                        manager.getBeepEnnemi().interrupt();
                                                                        Text txt = new Text("GAME OVER");
                                                                        txt.setTextAlignment(TextAlignment.CENTER);
                                                                        ecran.getChildren().add(txt);
                                                                        txt.setX(ecran.getWidth()/2);
                                                                        txt.setY(ecran.getHeight()/2);
                                                                    }
                                                                    if(manager.getMap().getEnnemis().isEmpty()){
                                                                        manager.getBeep().interrupt();
                                                                        manager.getBeepEnnemi().interrupt();
                                                                        Text txt = new Text("Victoire");
                                                                        txt.setTextAlignment(TextAlignment.CENTER);
                                                                        ecran.getChildren().add(txt);
                                                                        txt.setX(ecran.getWidth()/2);
                                                                        txt.setY(ecran.getHeight()/2);
                                                                    }
        });
//POINTS
        manager.getMap().nbEnnemisProperty().addListener(nbEnemis ->{
            manager.setPoints(manager.getPoints()+1);

        });
//POINTS
        ecran.widthProperty().addListener(largeur -> {manager.getMap().setWidth((int) ecran.getWidth());});
        ecran.heightProperty().addListener(largeur -> {manager.getMap().setHeight((int) ecran.getHeight());});
        Launcher.getStage().addEventFilter(KeyEvent.KEY_PRESSED, Event -> {manager.addTouche(Event.getCode());});
        Launcher.getStage().addEventFilter(KeyEvent.KEY_RELEASED, Event -> {manager.removeTouche(Event.getCode());});
    }


    @FXML
    public void updateMap(Map map){
        ecran.getChildren().removeAll(ecran.getChildren());
        for (Entite entity : map.getAllEntities()) {
//---TEST
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
            //POINTS

            TextField txt = new TextField();
            txt.textProperty().bindBidirectional(manager.getPointsProperty(), new NumberStringConverter());
            ecran.getChildren().add(txt);
            //POINTS
//---TEST
/*
        for (Entite entity : map.getAllEntities()) {
            Rectangle rec = new Rectangle();
            rec.layoutXProperty().bind(entity.getPos().xPosProperty());
            rec.layoutYProperty().bind(entity.getPos().yPosProperty());
            rec.setFill(Color.color((float) entity.getRedColor(),(float) entity.getGreenColor(),(float) entity.getBlueColor()));
            rec.setHeight(entity.getySize());
            rec.setWidth(entity.getxSize());
            rec.setId(entity.getId());
            ecran.getChildren().add(rec);
        }
 */
        }

        /*
        Text text = new Text();
        text.setText("HP: ");

        text.setX(100);
        text.setY(100);
        ecran.getChildren().add(text);
        */
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
