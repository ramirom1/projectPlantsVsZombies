package zombie;

public class ZombieSaltador extends Zombie {

    public ZombieSaltador(int row) {
        super(row);
        this.setName("Zombie Saltador");
    }

    //Falta implementar, lo podemos manejar desde game.Board
    public void jump(){
    }
}
