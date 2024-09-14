package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public abstract class Plants extends Entity {
    //atributos

    private int sunCost;
    private Board board;


    //constructor
    public Plants(String name, int healt, int column, int row, int sunCost, Board board, LinkedList<Entity> listClassification) {
        super(healt,name,column,row,listClassification);
        this.sunCost = sunCost;
        this.board = board;
    }

    public void takeDamage(int damage) {//el demage es el del zombie
        this.setLife(this.getLife()-damage); //le resto a la vida actual el daño que hace el zombie
        if (getLife() <= 0) {
            // la planta muere si su salud es menor o igual a 0
            die();
        }
    }

    private void die() {
        System.out.println(getName() + " ha muerto.");
        // Llama al tablero para eliminar la planta de su posición
        board.removeEntity(this, getRow(), getColumn());
        this.removeEntityList(this);
        if (this instanceof Patatapum){
            board.setCounterPatatapum(board.getCounterPatatapum()-1);
        } else if (this instanceof Girasol){
            board.setCounterGirasol(board.getCounterGirasol()-1);
        } else if (this instanceof Repetidora){
            board.setCounterRepetidora(board.getCounterRepetidora()-1);
        }
    }

    //gets

    //get costo
    public int getSunCost() {
        return sunCost;
    }

    //set para costo
    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }

}
