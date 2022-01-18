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
    private ArrayList<Attack> allAttacks = new ArrayList<Attack>();
    private ArrayList<Ennemi> allEnemi = new ArrayList<Ennemi>();
    private IntegerProperty nbEntite = new SimpleIntegerProperty();
    private int width;
    private int height;

    public void addEntity(Entite entity) {
        allEntities.add(entity);
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
        return allEnemi;
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
        setNbEntite(getNbEntite()-1);
    }

    public void removeAttack (Attack atk){
        allAttacks.remove(atk);
        removeEntity(atk);
    }

    public void addEnemy (Ennemi enmy){
        allEnemi.add(enmy);
        addEntity(enmy);
    }

    public void removeEnemy (Ennemi enemy){
        allEnemi.remove(enemy);
        removeEntity(enemy);
    }

    public ArrayList<Attack> getAllAttacks() {
        return (ArrayList<Attack>) allAttacks.clone();
    }
}
