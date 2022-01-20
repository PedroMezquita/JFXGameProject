package vue;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Manager;
import model.entities.*;
import launch.Launcher;
import model.maps.Map;

//code-behind de Background1.fxml
public class Background1 {

    @FXML
    private Pane ecran;

    private static Manager manager = new Manager();


    public void initialize() {
        ecran.setPrefWidth(500);
        ecran.setPrefHeight(500);
        ecran.setMinHeight(500);
        ecran.setMinWidth(500);
        ecran.widthProperty().addListener(largeur -> {manager.getMap().setWidth((int) ecran.getWidth());});
        ecran.heightProperty().addListener(largeur -> {manager.getMap().setHeight((int) ecran.getHeight());});
        Launcher.getStage().addEventFilter(KeyEvent.KEY_PRESSED, Event -> {manager.addTouche(Event.getCode());});
        Launcher.getStage().addEventFilter(KeyEvent.KEY_RELEASED, Event -> {manager.removeTouche(Event.getCode());});
        setUp();
    }

    //charge la map actuelle du manager
    public void setUp (){
        Image img = new Image(manager.getMap().getImage());
        BackgroundImage backImg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background back = new Background(backImg);
        ecran.getChildren().removeAll(ecran.getChildren());
        ecran.setBackground(back);

        updateMap(manager.getMap());
        manager.getMap().nbEntiteProperty().addListener(nbEntite ->{updateMap(manager.getMap());});

        manager.getJoueur().currentHPProperty().addListener(pv -> {
            if (manager.getJoueur().getCurrentHP() <= 0) {
                manager.stopBoucle();
                Text txt = new Text("GAME OVER");
                txt.setTextAlignment(TextAlignment.CENTER);
                ecran.getChildren().add(txt);
                txt.setX(ecran.getWidth() / 2);
                txt.setY(ecran.getHeight() / 2);
                setButtons();
            }
        });

        manager.getMap().nbEnnemisProperty().addListener(nbEnemis -> {  if(manager.getMap().getNbEnnemis() <= 0){
            //manager.stopBoucle();
            if(manager.niveauSuivant()) {
                setUp();
                //manager.startBoucle();
            }
            else{
                manager.stopBoucle();
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

    //charge une entité dans la vue
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
    }

    //met à jour la vue à partir d'une carte
    public void updateMap (Map map){
        for (Entite entity : map.getRemovedEntities()) {
            Node n = ecran.lookup("#"+entity.getId());
            ecran.getChildren().remove(n);
            map.eraseEntity(entity);
        }
        for (Entite entite : map.getNewEntities()){
            loadEntity(entite);
            map.handleEntity(entite);
        }
    }

    //créer les boutons recommencer et quitter
    public void setButtons (){

        Button restart = new Button("recommencer");
        restart.setOnAction(restartFire -> {
            recommencer();
        });
        ecran.getChildren().add(restart);
        restart.setLayoutX(150);
        restart.setLayoutY(250);


        Button quitter = new Button("quitter");
        quitter.setOnAction(quitterFire -> {
            quitter();
        });
        ecran.getChildren().add(quitter);
        quitter.setLayoutX(250);
        quitter.setLayoutY(250);
    }

    //fait recommencer la partie
    public void recommencer (){
        manager.init();
        setUp();
        //manager.startBoucle();
    }

    //ferme le jeu
    public void quitter (){
        Launcher.getStage().close();
    }

}
