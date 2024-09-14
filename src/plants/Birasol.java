package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class Birasol extends Girasol {
    // Constructor
    public Birasol(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column, row, board,listClassification);
        this.setName("Birasol");
        this.setSunCost(150);//
    }

    // Sobrescribimos el método generateSuns para generar el doble de soles
    @Override
    public int generateSuns() {
        return 50;
    }
}

