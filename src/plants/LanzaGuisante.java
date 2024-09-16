package plants;

import Entity.Attack;
import Entity.Entity;
import zombie.Zombie;
import game.Board;
import java.util.LinkedList;
import java.util.List;

/**
 * Representa el comportamiento de una planta de tipo LanzaGuisante.
 * Hereda de {@code Plants} e implementa la interfaz de {@code Attack}
 */
public class LanzaGuisante extends Plants implements Attack {
    private int damage;
    protected boolean slowDown = false;

    /**
     * Constructor de la clase {@code LanzaGuisante}.
     * Asigna sus atributos como salud, coste en soles, nombre y daño.
     * @param column Columna del tablero donde se ubica
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public LanzaGuisante(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super("Lanza Guisante",500,column,row,100,board,listClassification);
        this.damage = 100;
    }

    //implementacion attack

    /**
     * Realiza la acción de atacar a un zombie, restandole la vida correspondiente.
     * @param board Tablero donde se ubican tanto el LanzaGuisante como el zombie al que ataca.
     */
    public void attack(Board board) {
        // Obtener la posición de la planta
        int column = this.getColumn();
        int row = this.getRow();

        // Recorremos las columnas desde la posición actual hasta el final de la fila
        for (int j = column; j < 10; j++) {  // El tablero tiene 10 columnas
            // Obtenemos la lista de entidades en la casilla (x, j)
            List<Entity> entities = board.getEntitiesAt(row, j);

            // Buscar al primer zombie en la casilla actual
            for (Entity entity : entities) {
                if (entity instanceof Zombie) {
                    ((Zombie) entity).takeDamage(this.getDamage()); // La planta ataca al zombie
                    if (slowDown){
                        ((Zombie) entity).setSpeed(0);
                        ((Zombie) entity).setTotalFreezedRounds(0);
                    }
                    return; // Salimos del método tras atacar al primer zombie encontrado
                }
            }
        }
    }


    //get daño
    public int getDamage() {
        return damage;
    }

    //set daño
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isSlowDown() {
        return slowDown;
    }


}
