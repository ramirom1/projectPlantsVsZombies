package plants;

import Entity.Attack;
import Entity.Entity;
import game.Board;
import zombie.Zombie;

import java.util.LinkedList;
import java.util.List;

public class Patatapum extends Plants implements Attack {
    private int demage;
    private int loadTime;
    private boolean plantInGame;

    //constuctor
    public Patatapum(int column, int row,Board board, LinkedList<Entity> listClassification) {
        super("Patatapum",500,column,row, 25,1,1,board,listClassification);
        this.demage = 1500;
        this.loadTime = 2;
    }

    //accion de explotar
    // método que hace la explosión de la Patatapum
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
                    ((Zombie) entity).takeDamage(this.getDemage()); // Aplicar daño al zombie
                }
            }

            // Eliminar la Patatapum después de atacar
            board.removeEntity(this, row, column);
            // Eliminarla de la lista de plantas agresivas
            removeEntityList(this);
        }
    }

    //getters y setters
    public int getDemage() {
        return demage;
    }

    public int getLoadTime() {
        return loadTime;
    }
    public void setDemage(int demage) {
        this.demage = demage;
    }
    public void setLoadTime(int loadTime) {
        this.loadTime = loadTime;
    }

}
