package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa el comportamiento de una Repetidora, que hace el doble de daño que LanzaGuisante.
 * Hereda de {@code LanzaGuisante}
 */
public class Repetidora extends LanzaGuisante {
    //constructor

    /**
     * Constructor de la clase {@code Repetidora}. Asigna por defecto el nombre, daño y coste
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Repetidora(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
        this.setName("Repetidora");
        this.setDamage(200);
        this.setSunCost(200);
    }
}
