package model.attack;

//classe métier AttackPattern servant à décrire l'attaque d'un personnage afin de le faire attaquer
public class AttackPattern {
    //taille horizontale
    private int xSize;
    //taille verticale
    private int ySize;
    //temps de vie en nombre de déplacements
    private int lifeTime;
    //nombre de dégats
    private int degats;
    //identifiant
    private String id;
    //temps entre deux attaques
    private int cooldown;
    //temps restant avant la prochaine attaque
    private int currentcooldown;
    //valeur de rouge
    private double redColor;
    //valeur de vert
    private double greenColor;
    //valeur de bleu
    private double blueColor;
    //image
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

    //repasse le cooldown à sa valeur initiale
    public void resetCooldown (){
        currentcooldown = cooldown;
    }

}
