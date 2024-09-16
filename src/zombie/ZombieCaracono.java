package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa a un ZombieCaracono en el juego. Tiene más vida que el zombie estándar dado que lleva un cono.
 * Hereda de {@code Zombie}
 */
public class ZombieCaracono extends Zombie{

    /**
     * Constructor de la clase {@code ZombieCaracono}. Asigna por defecto el nombre y la vida.
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public ZombieCaracono(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Caracono");
        this.setLife(800);
    }
}
