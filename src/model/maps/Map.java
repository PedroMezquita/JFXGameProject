package model.maps;

import model.entities.Entite;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Map {  //Ce ne serais une meilleure idée de mettre map dans la vue ? en vrai oui, mais pour l'instant cela ne change pas de masses
    private ArrayList<Entite> allEntities = new ArrayList<Entite>();//elle contient la liste des entités

    public void addEntity (Entite entity){
        allEntities.add(entity);
    }

    public ArrayList<Entite> getAllEntities () {
        return allEntities;
    }

    public String toString (){
        return allEntities.toString();
    }
}
