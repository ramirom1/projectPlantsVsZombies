package plants;

import Entity.Attack;
import Entity.Entity;
import game.Board;
import zombie.Zombie;

import java.util.LinkedList;
import java.util.List;

/**
 * Representa el comportamiento de una planta de tipo Gasoseta
 * Hereda de {@code Patatapum}
 */
public class Gasoseta extends Patatapum {
    private int radio = 1;

    /**
     * Constructor de la clase {@code Gasoseta}. Asigna por defecto el radio de ataque, el nombre,
     * el daño y el coste en soles.
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Gasoseta(int column,int row,Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
        this.radio = 1;
        this.setName("Gasoseta");
        this.setDamage(150);
        this.setSunCost(150);
    }


    /**
     * Sobreescribe el metodo {@code attack} para adaptarlo a la forma de Gasoseta. Ataca en todas las direcciones
     * a lo largo de una casilla.
     */
    @Override
    public void attack(Board board) {
        int row = this.getRow();
        int column = this.getColumn();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < board.getRows() && j >= 0 && j < board.getCols()) {
                    // Obtener la lista de entidades en la posición actual
                    List<Entity> entities = board.getEntitiesAt(i, j);
                    entities.removeIf(entity -> entity instanceof Plants);
                    // Iterar sobre todas las entidades en esta casilla

                    for (int k = 0; k < entities.size(); k++) {

                        Entity entity = entities.get(k);

                        // Verificar si la entidad es un Zombie antes de aplicar el daño
                        ((Zombie) entity).takeDamage(this.getDamage());  // Aplicar daño al zombie
                    }
                }
            }
        }

    }

    public int getRadio() {
        return radio;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }

}
