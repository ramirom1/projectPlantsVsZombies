package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa a un ZombieSaltador en el juego. Tiene una garrocha que, al encontrarse con la primer planta, la utiliza
 * para saltarla y pasar a la siguiente casilla.
 * Hereda de {@code Zombie}
 */
public class ZombieSaltador extends Zombie {

    /**
     * Constructor de la clase {@code ZombieSaltador}. Asigna por defecto el nombre.
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public ZombieSaltador(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Saltador");
    }
}
