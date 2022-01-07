package model;

import java.util.ArrayList;

//a continuer plus tard
public class Loop extends Thread{

    int timer;
    ArrayList<Observer> listeObs = new ArrayList<Observer>();

    public Loop (int timer){
        this.timer = timer;
    }

    public void attacher (Observer obs){
        listeObs.add(obs);
    }

    public void detacher (Observer obs){
        listeObs.remove(obs);
    }


    @Override
    public void run() {
        while(true) { //ça marche a moitie, on peux faire mieux mais pour l'instant ça fait un peu la tache
            try {
                sleep(timer);
                beep();
            } catch (InterruptedException e) {
                break;
            }

        }
    }

    public void beep() {
        for (Observer obs: listeObs) {
            obs.update();
        }
    }

}
