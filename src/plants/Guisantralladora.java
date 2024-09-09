package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class Guisantralladora extends Repetidora{

    //constructor
    public Guisantralladora(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
        this.setDemage(400);
        this.setName("Guisantralladora");
        this.setSunCost(250);
        this.setPlantInGame(false);
        //falta lo del tiempo
    }
}
