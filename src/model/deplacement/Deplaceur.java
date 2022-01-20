package model.deplacement;


import model.Direction;
import model.entities.Personnage;

//interface pour les déplacement
public interface Deplaceur {

    //déplace un personnage dans une direction
    void deplacer(Personnage pers, Direction dir); //C'est abstrait mais si cela ne serais pas abstrait rien ne change

}


