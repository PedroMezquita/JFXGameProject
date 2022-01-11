package vue;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import model.entities.*;
import launch.Launcher;
import model.maps.Map;

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
        Launcher.getManager().getJoueur().getPos().xPosProperty().addListener(xProperty -> {
        //    Rectangle rec = (Rectangle) Launcher.getStage().getScene().lookup(Launcher.getManager().getJoueur().getId());

            Rectangle rec = (Rectangle) ecran.getChildren().get(0); //vu que la position du joueur dans le stub est 0 il sera toujours en tete de liste et donc ajouté en premier
            rec.setX(Launcher.getManager().getJoueur().getPos().getxPos());
        });
        Launcher.getManager().getJoueur().getPos().yPosProperty().addListener(yProperty -> {
        //    Rectangle rec = (Rectangle) Launcher.getStage().getScene().lookup(Launcher.getManager().getJoueur().getId());//Launcher.getManager().getJoueur().getId() Donne "joueur", getName() = "mec"

            Rectangle rec = (Rectangle) ecran.getChildren().get(0); //vu que la position du joueur dans le stub est 0 il sera toujours en tete de liste et donc ajouté en premier
            rec.setY(Launcher.getManager().getJoueur().getPos().getyPos()); //Il detecte les positions inverses
        });

        Launcher.getManager().getMap().nbEntiteProperty().addListener(nbEntite ->{updateMap(Launcher.getManager().getMap());});

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
            ecran.getChildren().removeAll();
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
