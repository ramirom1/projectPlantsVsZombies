package zombie;
import Entity.Entity;
import Entity.Attack;
import game.Board;
import plants.Plants;
import java.util.List;


public class Zombie extends Entity implements Attack {
    private int speed;
    private int demage;

    public Zombie(int row) {
        super(500, "Zombie", 9, row);
        this.speed = 1; //1 velocidad normal, 2 velocidad rápida
        this.demage = 100;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDemage() {
        return demage;
    }

    public void attack(Board board) {
        int row = getRow();
        int col = getColumn();
        List<Entity> entities = board.getEntitiesAt(row, col);

        for (Entity entity : entities) {
            if (entity instanceof Plants) {
                Plants plant = (Plants) entity;
                plant.takeDamage(this.getDemage());
                System.out.println("Zombie ataca a la planta en (" + row + ", " + col + ").");
                break; // Solo atacar a una planta por vez
            }
        }

    }
    public void takeDamage(int damage) {//el demage es el de la planta NO EL DEL ZOMBIE
        this.setLife(this.getLife()-damage); //le resto a la vida actual el daño que hace la planta
        if (getLife() <= 0) {
             // El zombie muere si su salud es menor o igual a 0
        }
    }
    //El juego va a encargarse de mover de lugar a los zombies
}