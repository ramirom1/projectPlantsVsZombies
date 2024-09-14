package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

//definicion  de la subclase Sunflower
public class Girasol extends Plants {
    protected int sunsProduction; //25 soles

    // constructor llamo a la super clase y cargo  los valores
    public Girasol(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super("Girasol",100, column, row, 50,board,listClassification);
        this.sunsProduction = 25;
    }

    //metodo para generar sol
    public int generateSuns() {
        return this.sunsProduction;
    }

}


