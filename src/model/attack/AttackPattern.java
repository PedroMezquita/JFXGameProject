package model.attack;

public class AttackPattern {
    private int xSize;
    private int ySize;
    private int lifeTime;
    private int degats;
    private String id;
    private int cooldown;
    private int currentcooldown;
    private int redColor;
    private int greenColor;
    private int blueColor;
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

    public void setRGB(int redColor, int greenColor, int blueColor){
        this.redColor = redColor;
        this.greenColor = greenColor;
        this.blueColor = blueColor;
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
