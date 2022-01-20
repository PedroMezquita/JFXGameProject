package data;

import model.maps.Map;

public abstract class Niveau implements Loader{

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

    public Niveau getLast () {
        if (niveauSuivant == null){
            return this;
        }
        return niveauSuivant.getLast();
    }
}
