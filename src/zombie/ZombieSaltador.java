package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class ZombieSaltador extends Zombie {

    public ZombieSaltador(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Saltador");
    }
}
