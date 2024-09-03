package zombie;
import Entity.Entity;
import Entity.Attack;

public class Zombie extends Entity implements Attack {
    private int speed;

    public Zombie(int positionY) {
        super(500, "Zombie", 10, positionY);
        this.speed = 1; //1 velocidad normal, 2 velocidad rápida
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void attack(){
    }

    //El juego va a encargarse de mover de lugar a los zombies
}