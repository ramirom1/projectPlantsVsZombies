package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class ZombieAbanderado extends Zombie{

    public ZombieAbanderado(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Abanderado");
    }

    public void setInvasion(){
        System.out.println("Se acerca una oleada de zombies");
    }
}
