package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class Nuez extends Plants{

    //constructor
    public Nuez(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super("Nuez",1500,column,row,50,board,listClassification);
    }

}
