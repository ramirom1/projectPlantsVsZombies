package zombie;
import Entity.Entity;
import Entity.Attack;
import game.Board;


public class Zombie extends Entity implements Attack {
    private int speed;

    public Zombie(int positionY) {
        super(500, "Zombie", 3, positionY);
        this.speed = 1; //1 velocidad normal, 2 velocidad rápida
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }


    public void attack(Board board){
        //aca va la logica del ataque del zombie
    }

    public void takeDamage(int damage) {//el demage es el de la planta NO EL DEL ZOMBIE
        this.setLife(this.getLife()-damage); //le resto a la vida actual el daño que hace la planta
        if (getLife() <= 0) {
             // El zombie muere si su salud es menor o igual a 0
        }
    }
    //El juego va a encargarse de mover de lugar a los zombies
}