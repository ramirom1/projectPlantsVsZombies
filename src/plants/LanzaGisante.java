package plants;


import Entity.Attack;

public class LanzaGisante extends Plants implements Attack {
    private int demage;

    public LanzaGisante(int x, int y) {
        super("Lanza Guisante",500,x,y,100,1,1);
        this.demage = 100;
    }

    public void attack(){
        //quitar vida al zombie
        System.out.println("Lanza Guisante atacado");
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
