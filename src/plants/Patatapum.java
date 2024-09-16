package plants;

import Entity.Attack;
import Entity.Entity;
import game.Board;
import zombie.Zombie;

import java.util.LinkedList;
import java.util.List;

/**
 * Representa el comportamiento de una planta de tipo Patatapum.
 * Hereda de {@code Plants} e implementa la interfaz {@code Attack}
 */
public class Patatapum extends Plants implements Attack {
    private int damage;
    private int roundsSincePlanted;

    //constuctor

    /**
     * Constructor de la clase {@code Patatapum}.
     * Asigna por defecto el nombre, vida y coste en soles.
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Patatapum(int column, int row,Board board, LinkedList<Entity> listClassification) {
        super("Patatapum",500,column,row, 25,board,listClassification);
        this.damage = 1500;
        this.roundsSincePlanted = 0;
    }

    //accion de explotar
    // método que hace la explosión de la Patatapum

    /**
     * Realiza el ataque de patatapum, eliminando los zombies sobre su posición.
     * @param board Tablero donde se encuentra ubicada la instancia de Patatapum
     */
    public void attack(Board board) {
        // Obtener la posición de la Patatapum
        int row = this.getRow();
        int column = this.getColumn();

        // Obtener la lista de entidades en la posición actual (donde está la Patatapum)
        List<Entity> entities = board.getEntitiesAt(row, column);

        // Verificar si hay algún zombie en la misma casilla
        boolean zombiePresent = entities.stream().anyMatch(entity -> entity instanceof Zombie);

        if (zombiePresent) {
            // Eliminar las plantas de la lista antes de aplicar daño
            entities.removeIf(entity -> entity instanceof Plants);

            // Aplicar daño a todos los zombies en la misma casilla
            for (int i = 0; i < entities.size(); i++) {
                Entity entity = entities.get(i);
                if (entity instanceof Zombie) {
                    ((Zombie) entity).takeDamage(this.getDamage()); // Aplicar daño al zombie
                }
            }

            // Eliminar la Patatapum después de atacar
            board.removeEntity(this, row, column);
            // Eliminarla de la lista de plantas agresivas
            removeEntityList(this);
        }
    }

    //getters y setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setRoundsSincePlanted(int roundsSincePlanted) {
        this.roundsSincePlanted = roundsSincePlanted;
    }
    public int getRoundsSincePlanted(){
        return roundsSincePlanted;
    }
}
