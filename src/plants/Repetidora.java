package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class Repetidora extends LanzaGuisante {
    //constructor
    public Repetidora(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
        this.setName("Repetidora");
        this.setDamage(200);
        this.setSunCost(200);
    }
}
