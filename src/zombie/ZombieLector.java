package zombie;

public class ZombieLector extends Zombie{

    public ZombieLector(int positionY) {
        super(positionY);
        this.setName("Zombie Lector");
        this.setLife(700);
    }

    //Queda ver como hacemos la verificación de la vida
    public void increaseSpeed(){
        if (this.getLife() <= 400) {
            this.setSpeed(2);
        }
    }
}
