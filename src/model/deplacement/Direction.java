package model.deplacement;

public class Direction {
    private int xDir;
    private int yDir;

    public Direction(int xDir, int yDir){
        if (xDir < -1 || xDir > 1 || yDir < -1 || yDir > 1)
            throw (new IllegalArgumentException());
        else{
            this.xDir = xDir;
            this.yDir = yDir;
        }
    }

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

    /*
    public void detectDirection(String codeString){
        switch (codeString){
            case "UP":
                setyDir(-1);
                setxDir(0);
                break;

            case "DOWN":
                setyDir(1);
                setxDir(0);
                break;

            case "RIGHT":
                setxDir(1);
                setyDir(0);
                break;

            case "LEFT":
                setxDir(-1);
                setyDir(0);
                break;
            default:
                System.out.println(codeString);
        }
        //A CHANGER



    }
*/

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