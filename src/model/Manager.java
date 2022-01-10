package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;
import model.deplacement.CollisioneurCarre;
import model.deplacement.DeplacerJoueur;
import model.deplacement.Direction;
import model.entities.*;
import model.maps.Map;
import model.maps.TestMap;
import launch.Launcher;
import data.Stub;
import vue.Background1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;

public class Manager {

    private ArrayList<KeyCode> listeTouches = new ArrayList<KeyCode>();
    private Hashtable<KeyCode, String> keyEvents = new Hashtable<KeyCode, String>();
    private Map map;
    private Joueur joueur;

    public Manager (){
        map = new Stub().load();
        joueur = map.getJoueur();
        addKeyEvent(KeyCode.RIGHT, "deplacerDroite");
        Loop beep = new Loop(1000);
        beep.attacher(new BeepObserver());
        beep.start();
    }

    public Map getMap() {
        return map;
    }

    public void addTouche (KeyCode s){
        if (! listeTouches.contains(s)){
            listeTouches.add(s);
        }
    }

    public ArrayList<KeyCode> getListeTouches() {
        return listeTouches;
    }

    public void resetListeTouches(){
        listeTouches = new ArrayList<KeyCode>();
    }

    public void addKeyEvent (KeyCode touche, String method){
        keyEvents.put(touche, method);
    }

    public void readKeys (){
        for (Iterator<KeyCode> it = listeTouches.iterator(); it.hasNext(); ) {
            KeyCode touche = it.next();
            try {
                Method method = this.getClass().getMethod(keyEvents.get(touche));
                method.invoke(this);
            }
            catch (Exception e){
                System.out.println("méthode non existante ou paramètres érroné\n");
            }
        }
    }

    public void deplacerDroite () {
        Direction dir = new Direction(1,0);
        DeplacerJoueur deplaceur = new DeplacerJoueur(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Droite");
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
