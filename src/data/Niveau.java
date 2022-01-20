package data;

import model.maps.Map;

//classe abstraite de base des niveaux de difficulté
public abstract class Niveau implements Loader{

    //niveau suivant ce niveau
    private Niveau niveauSuivant;

    @Override
    public Map load() {
        return null;
    }

    public Niveau getNiveauSuivant() {
        return niveauSuivant;
    }

    public void setNiveauSuivant(Niveau niveauSuivant) {
        this.niveauSuivant = niveauSuivant;
    }

    //retourne le dernier niveau de l'enchainement des niveau suivant
    public Niveau getLast () {
        if (niveauSuivant == null){
            return this;
        }
        return niveauSuivant.getLast();
    }
}
