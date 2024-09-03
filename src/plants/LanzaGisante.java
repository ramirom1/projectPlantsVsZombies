package plants;


public class LanzaGisante extends Plants {
    private int demage;

    public LanzaGisante(int x, int y) {
        super("Lanza Guisante",500,x,y,100,1,1);
        this.demage = 100;
    }

    //get daño
    public int getDemage() {
        return demage;
    }

    //set daño
    public void setDemage(int demage) {
        this.demage = demage;
    }
    //public void attack(){

    //}
}
