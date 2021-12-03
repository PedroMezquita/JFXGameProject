package model;
//a continuer plus tard
public class Loop {
    public void beep(){
        while (true) {
            try {
                wait(5);
            } catch (InterruptedException exception) {
            }
            notifyAll();
        }
    }
}
