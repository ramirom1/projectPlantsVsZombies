package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

//definicion  de la subclase Sunflower

/**
 * Subclase de {@code Plants} que implementa a los Girasoles.
 */
public class Girasol extends Plants {
    protected int sunsProduction; //25 soles

    // constructor llamo a la super clase y cargo  los valores

    /**
     * Constructor de la clase Girasol que asigna por defecto la cantidad de soles que produce, su nombre, su salud
     * y su coste en soles.
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Girasol(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super("Girasol",100, column, row, 50,board,listClassification);
        this.sunsProduction = 25;
    }

    /**
     * Genera la cantidad de soles correspondiente
     * @return La cantidad de soles generados
     */
    //metodo para generar sol
    public int generateSuns() {
        return this.sunsProduction;
    }

}


