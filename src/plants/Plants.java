package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Clase abstracta que hereda de {@code Entity} y representa a las plantas, que van a ser las aliadas del jugador.
 * Las subclases de {@code Plants} implementarán su tipo de comportamiento particular.
 */
public abstract class Plants extends Entity {
    //atributos

    private int sunCost;
    private Board board;


    //constructor

    /**
     * Constructor de la clase abstracta {@code Plants}.
     * Inicializa los atributos comunes de las plantas, como el coste en soles y el tablero al que pertenecen,
     * además de los atributos heredados de {@code Entity}.
     * @param name Nombre de la planta
     * @param healt Puntos de vida de la planta
     * @param column Columna del tablero donde se encuentra ubicada la planta
     * @param row Fila del tablero donde se encuentra ubicada la planta
     * @param sunCost Coste en soles
     * @param board Referencia al tablero donde se encuentra ubicada
     * @param listClassification La clasificacion de entidades a la que pertenece la planta
     */
    public Plants(String name, int healt, int column, int row, int sunCost, Board board, LinkedList<Entity> listClassification) {
        super(healt,name,column,row,listClassification);
        this.sunCost = sunCost;
        this.board = board;
    }

    /**
     * Recibe el daño que le han realizado, restándole puntos de vida
     * @param damage cantidad de puntos de vida que van a ser quitados
     */
    public void takeDamage(int damage) {//el demage es el del zombie
        this.setLife(this.getLife()-damage); //le resto a la vida actual el daño que hace el zombie
        if (getLife() <= 0) {
            // la planta muere si su salud es menor o igual a 0
            die();
        }
    }

    /**
     * Elimina la planta del tablero y, en caso de corresponder, decrementa el contador de los tipos de planta
     * que son base a las mejoras de la tienda de Crazy Dave
     */
    private void die() {
        System.out.println(getName() + " ha muerto.");
        // Llama al tablero para eliminar la planta de su posición
        board.removeEntity(this, getRow(), getColumn());
        this.removeEntityList(this);
        if (this instanceof Patatapum){
            board.setCounterPatatapum(board.getCounterPatatapum()-1);
        } else if (this instanceof Girasol){
            board.setCounterGirasol(board.getCounterGirasol()-1);
        } else if (this instanceof Repetidora){
            board.setCounterRepetidora(board.getCounterRepetidora()-1);
        }
    }

    //gets

    //get costo
    public int getSunCost() {
        return sunCost;
    }

    //set para costo
    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }

}
