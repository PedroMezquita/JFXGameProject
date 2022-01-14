package model.entities;

public abstract class Entite {  //Je pense que le nom pourrais aussi etre Size
    private int xSize; //les tailles sont à diviser par deux car on part du milieu de l'entité donc on fera -taille et + taille
    private int ySize;
    private Position position;  //attribut à garder pour la map et les props
    private String id;
    private int redColor;
    private int blueColor;
    private int greenColor;

    public Entite(int xSize, int ySize, int xpos, int ypos, String id, int redColor, int greenColor, int blueColor){
        this.xSize = xSize;
        this.ySize = ySize;
        this.position = new Position(xpos, ypos);
        this.id = id;
        this.redColor = redColor;
        this.blueColor = blueColor;
        this.greenColor = greenColor;
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

    public String getId () {
        return id;
    }

    public int getRedColor() {
        return redColor;
    }

    public int getGreenColor() {
        return greenColor;
    }

    public int getBlueColor() {
        return blueColor;
    }
}

