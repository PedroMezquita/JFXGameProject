package model;

public class Direction {
    private int xDir;
    private int yDir;


    public int getxDir() {
        return xDir;
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }
}
/*
Nouvelle classe

Explication:
    Ceci est une direction
    Elle represente la direction dans une grille 1,1
    Exemple:

        -1,1   (y)    1,1
           \   0,1   /
            \   |   /
              \ | /
     -1,0 ------0------ 1,0 (x)
              / | \
            /   |   \
          /    0,-1   \
        -1,-1         1,-1


    Ceci nous donne une possibilité de 8 directions facilement detectables


 */