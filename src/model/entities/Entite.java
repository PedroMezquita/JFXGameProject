package model.entities;

public abstract class Entite {  //Je pense que le nom pourrais aussi etre Size
    private int xSize; //les tailles sont à diviser par deux car on part du milieu de l'entité donc on fera -taille et + taille
    private int ySize;
    private Position position;  //attribut à garder pour la map et les props
    private String id;
    private int redColor;
    private int blueColor;
    private int greenColor;
    private String sprite;

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

    public int getRedColor() {
        return redColor;
    }

    public int getGreenColor() {
        return greenColor;
    }

    public int getBlueColor() {
        return blueColor;
    }

    public void setRedColor(int redColor) {
        this.redColor = redColor;
    }

    public void setGreenColor(int greenColor) {
        this.greenColor = greenColor;
    }

    public void setBlueColor(int blueColor) {
        this.blueColor = blueColor;
    }

    public  void setRGB (int redColor,int greenColor,int blueColor){
        this.redColor = redColor;
        this.greenColor = greenColor;
        this.blueColor = blueColor;
    }

    //---TEST
    public String getSprite(){return sprite;}

    public void setSprite(String sprite) {this.sprite = sprite;}
    //---TEST
}

