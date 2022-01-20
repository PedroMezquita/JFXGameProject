package model.entities;

//classe métier Props qui représente les obstacles de la carte
public class Props extends Entite {

    public Props(double xSize, double ySize, double xpos, double ypos, String id) {

        super((int)xSize, (int)ySize, (int)xpos, (int)ypos, id);
    }
}
