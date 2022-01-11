package model.deplacement;


import model.Direction;
import model.entities.Personnage;

public interface Deplaceur {

    public void deplacer(Personnage pers, Direction dir); //C'est abstrait mais si cela ne serais pas abstrait rien ne change

}


