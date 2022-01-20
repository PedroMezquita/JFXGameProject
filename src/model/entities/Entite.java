package model.entities;

//élément de base contenu dans une carte
public abstract class Entite {
    private int xSize; //taille horizontale
    private int ySize; //taille verticale
    private Position position;  //position de l'entité
    private String id; //identifiant de l'entité
    private double redColor; //valeur de rouge de l'entité
    private double blueColor; //valeur de vert de l'entité
    private double greenColor; //valeur de bleu de l'entité
    private String sprite; //image

    public Entite(int xSize, int ySize, int xpos, int ypos, String id){
        this.xSize = xSize;
        this.ySize = ySize;
        this.position = new Position(xpos, ypos);
        this.id = id;;
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

    public double getRedColor() {
        return redColor;
    }

    public double getGreenColor() {
        return greenColor;
    }

    public double getBlueColor() {
        return blueColor;
    }

    public void setRedColor(float redColor) {
        this.redColor = redColor;
    }

    public void setGreenColor(float greenColor) {
        this.greenColor = greenColor;
    }

    public void setBlueColor(float blueColor) {
        this.blueColor = blueColor;
    }

    public  void setRGB (double redColor,double greenColor,double blueColor){
        this.redColor = redColor;
        this.greenColor = greenColor;
        this.blueColor = blueColor;
    }

    public String getSprite(){return sprite;}

    public void setSprite(String sprite) {this.sprite = sprite;}
}

