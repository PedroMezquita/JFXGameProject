package model.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Position {
    private final IntegerProperty xPos = new SimpleIntegerProperty();
    private final IntegerProperty yPos = new SimpleIntegerProperty();

    public Position(int xPos, int yPos){
        this.xPos.set(xPos);
        this.yPos.set(yPos);
    }

    public int getxPos() {
        return xPos.get();
    }

    public void setxPos(int xPos) { this.xPos.set(xPos);   }

    public int getyPos() {
        return yPos.get();
    }

    public void setyPos(int yPos) {
        this.yPos.set(yPos);
    }

    public IntegerProperty xPosProperty (){
        return xPos;
    }
    public IntegerProperty yPosProperty (){
        return yPos;
    }
}
