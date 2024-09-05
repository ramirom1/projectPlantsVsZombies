package zombie;

public class ZombieAbanderado extends Zombie{

    public ZombieAbanderado(int row) {
        super(row);
        this.setName("Zombie Abanderado");
    }

    public void setInvasion(){
        System.out.println("Se acerca una oleada de zombies");
    }
}
