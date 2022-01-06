package model;

import javafx.scene.shape.Rectangle;
import model.deplacement.CollisioneurCarre;
import model.deplacement.DeplacerJoueur;
import model.deplacement.Direction;
import model.entities.Guerrier;
import model.entities.Personnage;
import model.entities.Props;
import model.maps.Map;
import model.maps.TestMap;
import launch.Launcher;
import data.Stub;
import vue.Background1;

public class Manager {

    public Manager (){
        Loop beep = new Loop(1000);
        beep.attacher(new BeepObserver());
        beep.start();

        Map map = new Stub().load();
        new Background1().updateMap(map);

        //DeplacerJoueur deplace = new DeplacerJoueur(new CollisioneurCarre(map));//On garde une direction (a la base elle est nulle

        //à partir de là, à mettre dans le code behind
        /*
        Rectangle rec = (Rectangle) Launcher.getStage().getScene().getRoot().lookup("#cercle");

        cercle.setHeight(joueur.getySize());
        cercle.setWidth(joueur.getxSize());
        cercle.setX(joueur.getPos().getxPos());
        cercle.setY(joueur.getPos().getyPos());

        //Detection et ajout des obstacles dans la liste obstacles
        Rectangle obst1 = (Rectangle) Launcher.getStage().getScene().getRoot().lookup("#obst1");
        Props obstacle1 = new Props(50,15,150,47,1);
        obst1.setHeight(obstacle1.getySize()); //hauteur = y, largeur = x
        obst1.setWidth(obstacle1.getxSize());
        obst1.setX(obstacle1.getPos().getxPos());
        obst1.setY(obstacle1.getPos().getyPos());

        //Instances des classes necessaires




        //Detection des touches (methode lambda qui va gerer le deplacement et l'interaction avec le joueur)


         */
    }
}
