package model;
//a continuer plus tard
public class ObserverCercle implements Observer{



    @Override
    public void update() {

    }

    public void observe(){
        while(true){
            try {
                wait(99999);
            }
            catch(InterruptedException exception)
            {}
            System.out.println("c'est bon");
        }
    }
}
