package plants;

public class HielaGuisante extends LanzaGisante{
    private boolean slowDown = true;

    //constructor
    public HielaGuisante(int x, int y) {
        super(x,y);
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
