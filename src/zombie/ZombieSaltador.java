package zombie;

public class ZombieSaltador extends Zombie {

    public ZombieSaltador(int positionY) {
        super(positionY);
        this.setName("Zombie Saltador");
    }

    //Falta implementar, lo podemos manejar desde game.Board
    public void jump(){
    }
}
