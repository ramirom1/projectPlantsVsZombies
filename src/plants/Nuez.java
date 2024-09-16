package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa el comportamiento de una planta de tipo Nuez.
 * Hereda de {@code Plants}
 */
public class Nuez extends Plants{

    //constructor

    /**
     * Constructor de la clase {@code Nuez}.
     * Asigna por defecto el nombre, vida y coste en soles.
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Nuez(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super("Nuez",1500,column,row,50,board,listClassification);
    }

}
