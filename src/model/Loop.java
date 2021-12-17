package model;
//a continuer plus tard
public class Loop extends Thread{

    int i = 0;
    @Override
    public void run() {
        while(true) { //ça marche a moitie, on peux faire mieux mais pour l'instant ça fait un peu la tache
            try {
                sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beep();
        }

    }

        public void beep () {
            ++i;
            System.out.println(i);
        }
    /*    public void beep(){
        while (true) {
            try {
                wait(5);
            } catch (InterruptedException exception) {
            }
            notifyAll();
        }
    }*/

}
