package plants;

import Entity.Attack;
import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class HielaGuisante extends LanzaGisante implements Attack {
    private boolean slowDown = true;

    //constructor
    public HielaGuisante(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
        this.setSunCost(175);
        this.setName("Hiela Guisante");
    }


    //get de si relentiza
    public boolean getSlowDown(){
        return slowDown;
    }

    //set de relentizar
    public void setSlowDown(boolean slowDown){
        this.slowDown = slowDown;
    }
}
