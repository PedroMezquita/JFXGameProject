package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;
import model.attack.Attack;
import model.attack.Degat;
import model.attack.Melee;
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
    private Direction lastDir; //nous aide a garder un "registre" de la derniere direction

    public Manager (){
        map = new Stub().load();
        joueur = map.getJoueur();
        addKeyEvent(KeyCode.RIGHT, "deplacerDroite");
        addKeyEvent(KeyCode.LEFT, "deplacerGauche");
        addKeyEvent(KeyCode.UP, "deplacerHaut");
        addKeyEvent(KeyCode.DOWN, "deplacerBas");
        addKeyEvent(KeyCode.SPACE, "attack");
        Loop beep = new Loop(100);
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
        lastDir = dir;
    }

    public void deplacerGauche () {
        Direction dir = new Direction(-1,0);
        DeplacerJoueur deplaceur = new DeplacerJoueur(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Gauche");
        lastDir = dir;
    }

    public void deplacerHaut() {
        Direction dir = new Direction(0,-1); //Pour une raison que je ne comprends si je met 1 ça decends au lieu de monter
        DeplacerJoueur deplaceur = new DeplacerJoueur(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Haut");
        lastDir = dir;
    }

    public void deplacerBas() {
        Direction dir = new Direction(0,1); //Pour une raison que je ne comprends si je met -1 ça monte au lieu de decendre
        DeplacerJoueur deplaceur = new DeplacerJoueur(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Bas");
        lastDir = dir;
    }
    public void attack() {
        Melee melee = new Melee(joueur, lastDir); //et voila le lastDir (une autre fois, desole garbage collector)
        Attack atk = new Attack(melee, joueur);
    }



    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
