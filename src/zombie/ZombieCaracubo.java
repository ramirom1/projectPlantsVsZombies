package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa a un ZombieCaracubo en el juego. Tiene más vida que el zombie caracono dado
 * que lleva un cubo que lo protege.
 * Hereda de {@code Zombie}
 */
public class ZombieCaracubo extends Zombie{

    /**
     * Constructor de la clase {@code ZombieCaracubo}. Asigna por defecto el nombre y la vida.
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public ZombieCaracubo(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Caracubo");
        this.setLife(1000);
    }
}
