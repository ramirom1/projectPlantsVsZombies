package zombie;
import Entity.Entity;
import Entity.Attack;
import game.Board;
import plants.Plants;

import java.util.LinkedList;
import java.util.List;

/**
 * Representa a la entidad de tipo Zombie que caracterizan a los enemigos.
 * Hereda de {@code Entity} e implementa la interfaz de {@code Attack}
 */
public class Zombie extends Entity implements Attack {
    private int speed;
    private int damage;
    private int totalFreezedRounds;
    private Board board;

    /**
     * Constructor de la clase {@code Zombie}. Asigna por defecto la columna donde se genera, el nombre,
     * la velocidad, el daño, y la cantidad de rondas que lleva congelado.
     * @param row Fila del tablero donde se ubica
     * @param board Referencia al tablero donde se encuentra
     * @param listClassification Clasificacion de entidades a la que pertenece
     */
    public Zombie(int row, Board board, LinkedList<Entity> listClassification) {
        super(400, "Zombie", 9, row, listClassification);
        this.speed = 1; //1 velocidad normal, 2 velocidad rápida
        this.damage = 25;
        this.board = board;
        this.totalFreezedRounds = 0;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setTotalFreezedRounds(int totalFreezedRounds) {
        this.totalFreezedRounds = totalFreezedRounds;
    }

    public int getTotalFreezedRounds() {
        return this.totalFreezedRounds;
    }

    /**
     * Realiza la acción de atacar del zombie hacia las plantas.
     * Esto sucede si el zombie se encuentra en el mismo casillero que la planta.
     * @param board Referencia al tablero donde se ubica el objeto de tipo Zombie
     */
    public void attack(Board board) {
        int row = getRow();
        int col = getColumn();
        List<Entity> entities = board.getEntitiesAt(row, col);

        for (Entity entity : entities) {
            if (entity instanceof Plants) {
                Plants plant = (Plants) entity;
                plant.takeDamage(this.getDamage());
                System.out.println("Zombie ataca a la planta en (" + row + ", " + col + ").");
                break; // Solo atacar a una planta por vez
            }
        }

    }

    /**
     * Aplica daño al zombie. Si la vida del zombie llega a 0 o menos, este muere.
     * Si el zombie es del tipo {@code ZombieLector} y su vida cae por debajo de 400,
     * su velocidad aumenta.
     *
     * @param damage Daño que recibe el zombie, infligido por una planta
     */
    public void takeDamage(int damage) {//el demage es el de la planta NO EL DEL ZOMBIE
        this.setLife(this.getLife()-damage); //le resto a la vida actual el daño que hace la planta
        if (getLife() <= 0) {
             // El zombie muere si su salud es menor o igual a 0
            die();
        }
        if (this instanceof ZombieLector ) {
            if (getLife() <= 400){
                this.setSpeed(2);
            }
        }
    }

    /**
     * Elimina al zombie del tablero, luego de que este haya sido eliminado.
     */
    private void die() {
        System.out.println(getName() + " ha muerto.");
        // Llama al tablero para eliminar el zombie de su posición
        board.removeEntity(this, getRow(), getColumn());
        this.removeEntityList(this);
    }

    //El juego va a encargarse de mover de lugar a los zombies
}