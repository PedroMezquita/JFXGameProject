package model;

public class LoopEnemi extends Loop{

    private boolean etatBoucle; //Pour detecter quand la boucle est finie et l'enemi doit bouger

    public LoopEnemi(int timer) {
        super(timer);
    }


    public boolean getEtat(){
        return etatBoucle;
    }

}
