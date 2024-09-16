package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa el comportamiento de una planta de tipo Guisantralladora, que hace el doble de daño que una Repetidora.
 * Hereda de {@code Repetidora}
 */
public class Guisantralladora extends Repetidora{

    //constructor

    /**
     * Constructor de la clase {@code Guisantralladora}.
     * Asigna por defecto el nombre, daño y coste en soles
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Guisantralladora(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
        this.setDamage(400);
        this.setName("Guisantralladora");
        this.setSunCost(250);
        //falta lo del tiempo
    }
}
