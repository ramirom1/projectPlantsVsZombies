package plants;

import Entity.Attack;
import game.Board;

public class HielaGuisante extends LanzaGisante implements Attack {
    private boolean slowDown = true;

    //constructor
    public HielaGuisante(int column, int row) {
        super(column,row);
        this.setSunCost(175);
        this.setName("Hiela Guisante");
    }

    //attack


    @Override
    public void attack(Board board) {
        //atacar al zombie
        //relentizarlo
        System.out.println("Hiela Guisante Ataca");
    }

    //get de si relentiza
    public boolean getSlowDown(){
        return slowDown;
    }

    //set de relentizar
    public void setSlowDown(boolean slowDown){
        this.slowDown = slowDown;
    }
}
