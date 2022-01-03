package model.attack;

import model.deplacement.Direction;
import model.entities.Personnage;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Melee extends Range{

    int ySize, xSize, minY, maxY, minX, maxX;

    public Melee(Personnage pers, Direction dir){
        if (dir.getyDir() == -1){
             minY = pers.getPos().getyPos();
             maxY = minY+ySize;
             minX = pers.getPos().getxPos()+pers.getxSize()/2-xSize/2;
             maxX = minX+xSize;
        }
        if (dir.getyDir() == 1){
            minY = pers.getPos().getyPos()-pers.getySize()-ySize;
            maxY = minY+ySize;
            minX = pers.getPos().getxPos()+pers.getxSize()/2-xSize/2;
            maxX = minX+xSize;
        }
        if (dir.getxDir() == -1){
            minY = pers.getPos().getyPos()-pers.getySize()/2-xSize/2;
            maxY = minY + xSize;
            minX = pers.getPos().getxPos()-ySize;
            maxX = minX+ySize;
        }
    }
}
