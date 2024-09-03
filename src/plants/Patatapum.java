package plants;

import Entity.Attack;

public class Patatapum extends Plants implements Attack {
    private int demage;
    private int loadTime;
    private boolean plantInGame;

    //constuctor
    public Patatapum(int x, int y) {
        super("Patatapum",500,x,y, 25,1,1);
        this.demage = 1500;
        this.loadTime = 2;
    }

    //accion de explotar
    public void attack(){
        //quitar vida a los zombies
        //desaparecer patatapum
        plantInGame = false;
        System.out.println("¡Boom!");
    }

    //getters y setters
    public int getDemage() {
        return demage;
    }

    public int getLoadTime() {
        return loadTime;
    }
    public void setDemage(int demage) {
        this.demage = demage;
    }
    public void setLoadTime(int loadTime) {
        this.loadTime = loadTime;
    }

}
