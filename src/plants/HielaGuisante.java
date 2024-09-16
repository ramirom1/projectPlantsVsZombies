package plants;

import Entity.Attack;
import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Representa el comportamiento de una planta de tipo HielaGuisante. Añade la habilidad de ralentizar a los enemigos.
 * Hereda de {@code LanzaGuisante}
 */
public class HielaGuisante extends LanzaGuisante {

    //constructor
    /**
     * Constructor de la clase {@code HielaGuisante}.
     * Asigna un coste en soles y el nombre de la planta.
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public HielaGuisante(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
        this.setSunCost(175);
        this.setName("Hiela Guisante");
    }

    /**
     * Sobrescribe el método {@code attack} para añadir la capacidad
     * de ralentizar a los enemigos.
     *
     * @param board El tablero en donde está ubicada
     */
    @Override
    public void attack(Board board) {
       super.attack(board);
       this.slowDown = true;
    }

    //get de si relentiza
    public boolean getSlowDown(){
        return slowDown;
    }

    //set de relentizar
    public void setSlowDown(boolean slowDown){
        this.slowDown = slowDown;
    }
}
