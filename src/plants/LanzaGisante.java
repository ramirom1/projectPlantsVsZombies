package plants;

import Entity.Attack;
import Entity.Entity;
import zombie.Zombie;
import game.Board;

import java.util.LinkedList;
import java.util.List;

public class LanzaGisante extends Plants implements Attack {
    private int demage;

    public LanzaGisante(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super("Lanza Guisante",500,column,row,100,1,1,board,listClassification);
        this.demage = 500;
    }

    //implementacion attack
    public void attack(Board board) {
        // Obtener la posición de la planta
        int x = this.getColumn();
        int y = this.getRow();

        // Recorremos las columnas desde la posición actual hasta el final de la fila
        for (int j = x; j < 10; j++) {  // El tablero tiene 10 columnas
            // Obtenemos la lista de entidades en la casilla (x, j)
            List<Entity> entities = board.getEntitiesAt(y, j);

            // Buscar al primer zombie en la casilla actual
            for (Entity entity : entities) {
                if (entity instanceof Zombie) {
                    ((Zombie) entity).takeDamage(this.getDemage()); // La planta ataca al zombie
                    System.out.println("Lanza Guisante atacó al zombie en (" + x + ", " + j + ").");
                    return; // Salimos del método tras atacar al primer zombie encontrado
                }
            }
        }

        // Si no hay zombies en la fila
        System.out.println("No hay zombies en la línea para atacar.");
    }


    //get daño
    public int getDemage() {
        return demage;
    }

    //set daño
    public void setDemage(int demage) {
        this.demage = demage;
    }


}
