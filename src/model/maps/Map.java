package model.maps;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.attack.Attack;
import model.entities.Ennemi;
import model.entities.Entite;
import model.entities.Joueur;

import java.util.ArrayList;

public abstract class Map {  //Ce ne serais une meilleure idée de mettre map dans la vue ? en vrai oui, mais pour l'instant cela ne change pas de masses
    private ArrayList<Entite> allEntities = new ArrayList<Entite>();//elle contient la liste des entités
    private ArrayList<Entite> removedEntities = new ArrayList<Entite>();
    private ArrayList<Entite> newEntities = new ArrayList<Entite>();
    private ArrayList<Attack> allAttacks = new ArrayList<Attack>();
    private ArrayList<Ennemi> allEnemi = new ArrayList<Ennemi>();
    private IntegerProperty nbEntite = new SimpleIntegerProperty();
    //POINTS
    private IntegerProperty nbEnemis = new SimpleIntegerProperty(0);
    //POINTS

    private int width;
    private int height;
    private String image;

    public void addEntity(Entite entity) {
        allEntities.add(entity);
        newEntities.add(entity);
        setNbEntite(getNbEntite()+1);
    }

    public void addAttack (Attack atk){
        allAttacks.add(atk);
        addEntity(atk);
    }

    public ArrayList<Entite> getAllEntities() {
        return allEntities;
    }

    public String toString() {
        return allEntities.toString();
    }

    public Joueur getJoueur() {
        for (Entite entity : getAllEntities()) {
            if (entity.getId() == "joueur") {
                return (Joueur) entity;
            }
        }
        return null;
    }

    public ArrayList<Ennemi> getEnnemis(){
        return (ArrayList<Ennemi>) allEnemi.clone();
    }

    public int getNbEntite() {
        return nbEntite.get();
    }

    public void setNbEntite(int nbEntite) {
        this.nbEntite.set(nbEntite);
    }

    public IntegerProperty nbEntiteProperty() {
        return nbEntite;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void removeEntity (Entite entity){
        allEntities.remove(entity);
        removedEntities.add(entity);
        setNbEntite(getNbEntite()-1);
    }

    public void removeAttack (Attack atk){
        allAttacks.remove(atk);
        removeEntity(atk);
    }

    public void addEnemy (Ennemi enmy){
        allEnemi.add(enmy);
        //POINTS
        setNbEnnemis(getNbEnnemis()+1);
        //POINTS
        addEntity(enmy);
    }

    public void removeEnemy (Ennemi enemy){
        allEnemi.remove(enemy);
        //POINTS
        setNbEnnemis(getNbEnnemis()-1);
        //POINTS
        removeEntity(enemy);
    }

    public ArrayList<Attack> getAllAttacks() {
        return (ArrayList<Attack>) allAttacks.clone();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    //POINTS


    public int getNbEnnemis() { return nbEnemis.get(); }

    public void setNbEnnemis(int nbEntite) {
        this.nbEnemis.set(nbEntite);
    }

    public IntegerProperty nbEnnemisProperty() {
        return nbEnemis;
    }
    //POINTS


    public ArrayList<Entite> getRemovedEntities() {
        return (ArrayList<Entite>) removedEntities.clone();
    }

    public void eraseEntity (Entite entite){
        removedEntities.remove(entite);
    }

    public void handleEntity (Entite entite){
        newEntities.remove(entite);
    }

    public ArrayList<Entite> getNewEntities() {
        return (ArrayList<Entite>) newEntities.clone();
    }
}
