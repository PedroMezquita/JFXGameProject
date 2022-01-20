package model;

import data.*;
import javafx.scene.input.KeyCode;
import model.IA.IA;
import model.IA.IAPathfind;
import model.attack.AtkUpdater;
import model.attack.Attack;
import model.attack.BasiqueAttacker;
import model.collisions.CollisioneurCarre;
import model.deplacement.DeplacerBasique;
import model.deplacement.Deplaceur;
import model.entities.*;
import model.maps.Map;

import java.lang.reflect.Method;
import java.util.*;

public class Manager {

    //liste des touches appuyées
    private HashSet<KeyCode> listeTouches = new HashSet<KeyCode>();
    //dictionnaire des méthodes à effectuer pour certaines touches
    private Hashtable<KeyCode, String> keyEvents = new Hashtable<KeyCode, String>();
    //dictionnaire précédent avec les clés et valeurs inversées
    private Hashtable<String, KeyCode> reversedKeyEvents = new Hashtable<String, KeyCode>();
    //carte actuelle
    private Map map;
    //joueur actuel
    private Joueur joueur;
    //boucle du joueur
    private Loop beep;
    //boucle des ennemis
    private Loop beepEnnemi;
    //numéro du niveau
    private Niveau lvl;

    public Manager (){
        init();
    }

    //charge le premier niveau et les controles
    public void init (){
        lvl = new Niveau1();
        lvl.getLast().setNiveauSuivant(new Niveau2());
        lvl.getLast().setNiveauSuivant(new Niveau3());
        lvl.getLast().setNiveauSuivant(new Niveau4());
        lvl.getLast().setNiveauSuivant(new Niveau5());
        map = lvl.load();
        map.setWidth(500);
        map.setHeight(500);
        joueur = map.getJoueur();
        addKeyEvent(KeyCode.RIGHT,  "deplacerDroite");
        addKeyEvent(KeyCode.LEFT, "deplacerGauche");
        addKeyEvent(KeyCode.UP, "deplacerHaut");
        addKeyEvent(KeyCode.DOWN, "deplacerBas");
        addKeyEvent(KeyCode.Z, "attaqueHaut");
        addKeyEvent(KeyCode.S, "attaqueBas");
        addKeyEvent(KeyCode.Q, "attaqueGauche");
        addKeyEvent(KeyCode.D, "attaqueDroite");

        initLoop();
    }

    //instancie la boucle de jeu
    public void initLoop (){
        beep = new Loop(50);
        beepEnnemi = new Loop(200);

        beep.attacher(new MainObserver(this));

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

    //lit la liste des touches appuyées et en effectue les actions
    public void readKeys (){
        for (Iterator<KeyCode> it = listeTouches.iterator(); it.hasNext(); ) {
            KeyCode touche = it.next();
            try {
                Method method = this.getClass().getMethod(keyEvents.get(touche));
                method.invoke(this);
            }
            catch (Exception e){
            }
        }
    }


    //appel le déplaceur pour déplacer le joueur à droite
    public void deplacerDroite () {
        Direction dir = new Direction(1,0);
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
    }

    //de meme à gauche
    public void deplacerGauche () {
        Direction dir = new Direction(-1,0);
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
    }

    //de même en haut
    public void deplacerHaut () {
        Direction dir = new Direction(0,-1); //Pour une raison que je ne comprends si je met 1 ça decends au lieu de monter
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
    }

    //de même en bas
    public void deplacerBas () {
        Direction dir = new Direction(0,1); //Pour une raison que je ne comprends si je met -1 ça monte au lieu de decendre
        DeplacerBasique deplaceur = new DeplacerBasique(new CollisioneurCarre(map));
        deplaceur.deplacer((Personnage)joueur, dir);
    }

    //appel l'attacker pour instancier une attaque
    public void attaqueHaut () {
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(0,-1 ));
        if (attaque != null) {
            map.addAttack(attaque);
        }
    }

    //de meme en bas
     public void attaqueBas () {
        if (listeTouches.contains(reversedKeyEvents.get("attaqueHaut"))){
            return;
        }
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(0, 1));
         if (attaque != null) {
             map.addAttack(attaque);
         }
    }

    //de meme à gauche
      public void attaqueGauche () {
          if (listeTouches.contains(reversedKeyEvents.get("attaqueHaut")) || listeTouches.contains(reversedKeyEvents.get("attaqueBas"))){
              return;
          }
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(-1, 0));
          if (attaque != null) {
              map.addAttack(attaque);
          }
    }

    //de meme à droite
     public void attaqueDroite () {
         if (listeTouches.contains(reversedKeyEvents.get("attaqueHaut")) || listeTouches.contains(reversedKeyEvents.get("attaqueGauche")) || listeTouches.contains(reversedKeyEvents.get("attaqueBas"))){
             return;
         }
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(1, 0));
         if (attaque != null) {
             map.addAttack(attaque);
         }
    }

    //appel le pathfincding et un déplaceur pour déplacer l'ennemi
    public void updateEnemi(){
        IA enemiIA = new IAPathfind();
        Deplaceur deplace = new DeplacerBasique(new CollisioneurCarre(map));
        for (Personnage ennemi : map.getEnnemis()){
            ennemi.getAttaque().setCurrentcooldown(ennemi.getAttaque().getCurrentcooldown()-1);
            Direction dir = enemiIA.approcheJoueur(joueur, ennemi, map);
            deplace.deplacer(ennemi, new Direction(dir.getxDir(),0));
            deplace.deplacer(ennemi, new Direction(0,dir.getyDir()));
        }

    }

    //appel un déplaceur d'attaque pour déplacer les attaques
    public void updateAttaque(){
        joueur.getAttaque().setCurrentcooldown(joueur.getAttaque().getCurrentcooldown()-1);
        AtkUpdater updater = new AtkUpdater();
        updater.updateAttack(map);
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Loop getBeep() {
        return beep;
    }

    public Loop getBeepEnnemi() {
        return beepEnnemi;
    }

    //passe le niveau courant au niveau suivant
    public Boolean niveauSuivant (){
        if (lvl.getNiveauSuivant() != null) {
            map.removeAll();
            lvl = lvl.getNiveauSuivant();
            map = lvl.load();
            map.setHeight(500);
            map.setWidth(500);
            joueur = map.getJoueur();
            return true;
        }
        return false;
    }

    //arrête les boucles
    public void stopBoucle(){
        beep.interrupt();
        beepEnnemi.interrupt();
    }

}
