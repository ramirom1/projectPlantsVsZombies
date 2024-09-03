package plants;

import Entity.Attack;

public class HielaGuisante extends LanzaGisante implements Attack {
    private boolean slowDown = true;

    //constructor
    public HielaGuisante(int x, int y) {
        super(x,y);
        this.setSunCost(175);
        this.setName("Hiela Guisante");
    }

    //attack


    @Override
    public void attack() {
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
