package model.entities;

public abstract class Entite {  //Je pense que le nom pourrais aussi etre Size
    private int xSize; //les tailles sont à diviser par deux car on part du milieu de l'entité donc on fera -taille et + taille
    private int ySize;
    private Position position;  //attribut à garder pour la map et les props
    private int id;

    public Entite(int xSize, int ySize, int xpos, int ypos, int id){
        this.xSize = xSize;
        this.ySize = ySize;
        this.position = new Position(xpos, ypos);
        this.id = id;
    }

    public Position getPos(){
        return position;
    }

    public void setPosition(int xPos, int yPos){
        position.setxPos(xPos);
        position.setyPos(yPos);
    }

    public int getySize () {
        return ySize;
    }

    public int getxSize () {
        return xSize;
    }

    public int getId () {
        return id;
    }

}

