package zombie;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa al ZombieAbanderado.
 * Hereda de la clase {@code Zombie}
 */
public class ZombieAbanderado extends Zombie{

    /**
     * Constructor de la clase {@code ZombieAbanderado}. Asigna por defecto el nombre
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public ZombieAbanderado(int row, Board board, LinkedList<Entity> listClassification) {
        super(row,board,listClassification);
        this.setName("Zombie Abanderado");
    }

    /**
     * Imprime un mensaje por pantalla que avisa que se aproxima una oleada de zombies.
     */
    public void setInvasion(){
        System.out.println("Se acerca una oleada de zombies");
    }
}
