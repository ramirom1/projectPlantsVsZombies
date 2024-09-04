package plants;

import Entity.Attack;
import game.Board;

public class Gasoseta extends Patatapum implements Attack {
    private int radio = 1;
    public Gasoseta(int x,int y){
        super(x,y);
        this.radio = 1;
        this.setName("Gasoseta");
        this.setDemage(150);
        this.setLoadTime(0);

    }

    @Override
    public void attack(Board board) {
        //quitar vida en un radio de 1 a todos los zombies
        //este no desaparece
        System.out.println("la gasoseta esta atacando");
    }

    public int getRadio() {
        return radio;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }

}
