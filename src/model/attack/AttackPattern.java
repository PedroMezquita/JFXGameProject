package model.attack;

public class AttackPattern {
    private int xSize;
    private int ySize;
    private int lifeTime;
    private int degats;
    private String id;
    private int cooldown;
    private int currentcooldown;
    private double redColor;
    private double greenColor;
    private double blueColor;
    private String sprite;

    public AttackPattern (int lifeTime, int degats, int xSize, int ySize, String id, int cooldown){
        this.lifeTime = lifeTime;
        this.degats = degats;
        this.xSize = xSize;
        this.ySize = ySize;
        this.id = id;
        this.cooldown = cooldown;
        this.currentcooldown = cooldown;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getDegats() {
        return degats;
    }

    public String getId() {
        return id;
    }

    public void setRGB(double redColor, double greenColor, double blueColor){
        this.redColor = redColor;
        this.greenColor = greenColor;
        this.blueColor = blueColor;
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

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }

    public int getCurrentcooldown() {
        return currentcooldown;
    }

    public void setCurrentcooldown(int currentcooldown) {
        this.currentcooldown = currentcooldown;
    }

    public void resetCooldown (){
        currentcooldown = cooldown;
    }

}
