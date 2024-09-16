package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

/**
 * Subclase de {@code Girasol} que implementa su mejora, ya que genera el doble de soles.
 */
public class Birasol extends Girasol {
    // Constructor

    /**
     * Constructor de la clase {@code Birasol} que asigna por defecto el nombre y su coste
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Birasol(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column, row, board,listClassification);
        this.setName("Birasol");
        this.setSunCost(150);//
    }

    // Sobrescribimos el método generateSuns para generar el doble de soles
    /**
     * Genera la cantidad de soles correspondiente
     * @return La cantidad de soles generados
     */
    @Override
    public int generateSuns() {
        return 50;
    }
}

