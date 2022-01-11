package model.attack;

public class AttackPattern {
    private int xSize;
    private int ySize;
    private int lifeTime;
    private int degats;
    private String id;

    public AttackPattern (int lifeTime, int degats, int xSize, int ySize, String id){
        this.lifeTime = lifeTime;
        this.degats = degats;
        this.xSize = xSize;
        this.ySize = ySize;
        this.id = id;
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
}
