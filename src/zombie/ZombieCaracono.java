package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class ZombieCaracono extends Zombie{

    public ZombieCaracono(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Caracono");
        this.setLife(800);
    }
}
