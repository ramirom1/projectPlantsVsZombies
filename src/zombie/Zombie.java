package zombie;
import Entity.Entity;

public class Zombie extends Entity {
    private int vidaZombie;

    public Zombie(int vidaZombie, int life, String name, int positionX, int positionY) {
        super(life, name, positionX, positionY);
        this.vidaZombie = vidaZombie;
    }
}
