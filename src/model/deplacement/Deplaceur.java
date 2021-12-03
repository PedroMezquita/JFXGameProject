package model.deplacement;


import model.entities.Personnage;

public interface Deplaceur {
    public void Deplacer(Personnage pers, Direction dir); //C'est abstrait mais si cela ne serais pas abstrait rien ne change
}
