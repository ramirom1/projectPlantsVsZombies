package zombie;

public class ZombieSaltador extends Zombie {

    public ZombieSaltador(int positionY) {
        super(positionY);
        this.setName("Zombie Saltador");
    }

    //Falta implementar, lo podemos manejar desde Board
    public void jump(){
    }
}
