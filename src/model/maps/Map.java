package model.maps;

import model.entities.Entite;

import java.util.LinkedList;

public abstract class Map {  //Ce ne serais une meilleure idée de mettre map dans la vue ?
    private LinkedList<Entite> allEntities = new LinkedList<>();//elle contient la liste des entités

    public void addEntity (Entite entity){
        allEntities.add(entity);
    }

    public String toString (){
        return allEntities.toString();
    }
}
