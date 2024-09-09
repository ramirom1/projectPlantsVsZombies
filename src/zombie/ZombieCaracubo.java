package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class ZombieCaracubo extends Zombie{

    public ZombieCaracubo(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Caracubo");
        this.setLife(1000);
    }
}
