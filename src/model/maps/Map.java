package model.maps;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import launch.Launcher;
import model.entities.Entite;
import model.entities.Joueur;
import model.entities.Mage;
import java.lang.Object;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

public abstract class Map {  //Ce ne serais une meilleure idée de mettre map dans la vue ? en vrai oui, mais pour l'instant cela ne change pas de masses
    private ArrayList<Entite> allEntities = new ArrayList<Entite>();//elle contient la liste des entités
    private IntegerProperty nbEntite = new SimpleIntegerProperty();

    public void addEntity(Entite entity) {
        allEntities.add(entity);
        setNbEntite(getNbEntite()+1);
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

    public int getNbEntite() {
        return nbEntite.get();
    }

    public void setNbEntite(int nbEntite) {
        this.nbEntite.set(nbEntite);
    }

    public IntegerProperty nbEntiteProperty() {
        return nbEntite;
    }

    public void removeEntity (Entite entity){
        allEntities.remove(entity);
        setNbEntite(getNbEntite()-1);
    }

}
