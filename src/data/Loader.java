package data;

import model.maps.Map;

//interface de chargement des données
public interface Loader {
    //méthode permettant de charger une Map
    Map load ();
}
