package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa a un ZombieLector en el juego. Tiene un diario que lo protege y, cuando se lo destruyen,
 * se enfurece.
 * Hereda de {@code Zombie}
 */
public class ZombieLector extends Zombie{

    /**
     * Constructor de la clase {@code ZombieLector}. Asigna por defecto el nombre, la vida y la velocidad.
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public ZombieLector(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Lector");
        this.setLife(700);
        this.setSpeed(1);
    }

    /**
     * Aumenta la velocidad del zombie cuando su diario es destruido.
     */
    public void increaseSpeed(){
        if (this.getLife() <= 400) {
            this.setSpeed(2);
        }
    }

}
