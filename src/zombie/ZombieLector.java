package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class ZombieLector extends Zombie{

    public ZombieLector(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Lector");
        this.setLife(700);
    }

    //Queda ver como hacemos la verificación de la vida
    public void increaseSpeed(){
        if (this.getLife() <= 400) {
            this.setSpeed(2);
        }
    }
}
