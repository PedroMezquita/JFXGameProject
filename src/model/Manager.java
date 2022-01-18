package model;

import javafx.scene.input.KeyCode;
import model.IA.IA;
import model.IA.IAPathfind;
import model.attack.AtkUpdater;
import model.attack.Attack;
import model.attack.Attacker;
import model.attack.BasiqueAttacker;
import model.collisions.CollisioneurCarre;
import model.deplacement.DeplacerBasique;
import model.deplacement.DeplacerEnnemie;
import model.deplacement.Deplaceur;
import model.entities.*;
import model.maps.Map;
import data.Stub;

import java.lang.reflect.Method;
import java.util.*;

public class Manager {

    private HashSet<KeyCode> listeTouches = new HashSet<KeyCode>();
    private Hashtable<KeyCode, String> keyEvents = new Hashtable<KeyCode, String>();
    private Hashtable<String, KeyCode> reversedKeyEvents = new Hashtable<String, KeyCode>();
    private Map map;
    private Joueur joueur;
    private ArrayList<Ennemi> listeEnemis;
    private Loop beep;
    private Loop beepEnnemi;
    //go rebrand le jeu en simulateur de pompier (idée de bouhours)

    public Manager (){
        map = new Stub().load();
        joueur = map.getJoueur();
        listeEnemis = map.getEnnemis();
        addKeyEvent(KeyCode.RIGHT,  "deplacerDroite");
        addKeyEvent(KeyCode.LEFT, "deplacerGauche");
        addKeyEvent(KeyCode.UP, "deplacerHaut");
        addKeyEvent(KeyCode.DOWN, "deplacerBas");
        addKeyEvent(KeyCode.Z, "attaqueHaut");
        addKeyEvent(KeyCode.S, "attaqueBas");
        addKeyEvent(KeyCode.Q, "attaqueGauche");
        addKeyEvent(KeyCode.D, "attaqueDroite");

        beep = new Loop(50);
        beepEnnemi = new Loop(200);

        beep.attacher(new MainObserver(this));
        beep.attacher(new GameOverObserver(this));
        beepEnnemi.attacher(new EnnemiObserver(this));
        beep.start();
        beepEnnemi.start();
    }

    public Map getMap() {
        return map;
    }

    public void addTouche (KeyCode s){
        listeTouches.add(s);
    }

    public void removeTouche (KeyCode s){
        listeTouches.remove(s);
    }

    public HashSet<KeyCode> getListeTouches() {
        return listeTouches;
    }

    public void resetListeTouches(){
        listeTouches = new HashSet<KeyCode>();
    }

    public void addKeyEvent (KeyCode touche, String method){
        keyEvents.put(touche, method);
        reversedKeyEvents.put(method,touche);
    }

    public void readKeys (){
        for (Iterator<KeyCode> it = listeTouches.iterator(); it.hasNext(); ) {
            KeyCode touche = it.next();
            try {
                Method method = this.getClass().getMethod(keyEvents.get(touche));
                method.invoke(this);
            }
            catch (Exception e){
                System.out.println(e+"\n");
            }
        }
    }



    public void deplacerDroite () {
        Direction dir = new Direction(1,0);
        //lastDir = dir;
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Droite");
        //lastDir = dir;
    }

    public void deplacerGauche () {
        Direction dir = new Direction(-1,0);
        //lastDir = dir;
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Gauche");
    }

    public void deplacerHaut () {
        Direction dir = new Direction(0,-1); //Pour une raison que je ne comprends si je met 1 ça decends au lieu de monter
        //lastDir = dir;
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Haut");
    }

    public void deplacerBas () {
        Direction dir = new Direction(0,1); //Pour une raison que je ne comprends si je met -1 ça monte au lieu de decendre
        //lastDir = dir;
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
        System.out.println("déplacer Bas");
    }

    public void attaqueHaut () {
        System.out.println("attaque\n");
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(0,-1 ));
        joueur.setCurrentAttack(attaque);
        map.addAttack(attaque);
    }

     public void attaqueBas () {
        System.out.println("attaque\n");
        if (listeTouches.contains(reversedKeyEvents.get("attaqueHaut"))){
            return;
        }
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(0, 1));
        joueur.setCurrentAttack(attaque);
        map.addAttack(attaque);
    }

      public void attaqueGauche () {
        System.out.println("attaque\n");
          if (listeTouches.contains(reversedKeyEvents.get("attaqueHaut")) || listeTouches.contains(reversedKeyEvents.get("attaqueBas"))){
              return;
          }
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(-1, 0));
        joueur.setCurrentAttack(attaque);
        map.addAttack(attaque);
    }

     public void attaqueDroite () {
        System.out.println("attaque\n");
         if (listeTouches.contains(reversedKeyEvents.get("attaqueHaut")) || listeTouches.contains(reversedKeyEvents.get("attaqueGauche")) || listeTouches.contains(reversedKeyEvents.get("attaqueBas"))){
             return;
         }
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(1, 0));
        joueur.setCurrentAttack(attaque);
        map.addAttack(attaque);
    }


    public void updateEnemi(){
        IA enemiIA = new IAPathfind();
        Deplaceur deplace = new DeplacerBasique(new CollisioneurCarre(map));
        for (Personnage ennemi : listeEnemis){
            Direction dir = enemiIA.approcheJoueur(joueur, ennemi, map);
            deplace.deplacer(ennemi, new Direction(dir.getxDir(),0));
            deplace.deplacer(ennemi, new Direction(0,dir.getyDir()));
        }

    }

    public void updateAttaque(){
        AtkUpdater updater = new AtkUpdater();
        updater.updateAttack(map);
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void gameOver(){
        beep.interrupt();
        beepEnnemi.interrupt();
    }
}
