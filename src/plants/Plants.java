package plants;

import Entity.Entity;

public class Plants extends Entity {
    //atributos

    private int sunCost;
    private float reloadTime; //timepo que demora en volver a cargar
    private float missingTime; //este tiempo tiene que disminuir hasta llegar a 0 para que se pueda volver a usar

    //constructor
    public Plants(String name,int healt, int positionX, int positionY, int sunCost, float reloadTime, float missingTime) {
        super(healt,name,positionX,positionY);
        this.sunCost = sunCost;
        this.reloadTime = reloadTime;
        this.missingTime = missingTime;

    }

    //metodo para saber si esta disponible  para usar(si ya cargo)
    public boolean available() {
        if (this.missingTime == 0) {
            return true; //retorna true si el tiempo es 0, hay que ver como lo hacemos disminuir
        } else{
            return false;//retorna false si todavia no se termina el tiempo de espera
        }
    }


    //gets

    //get costo
    public int getSunCost() {
        return sunCost;
    }
    //get de tiempo que demora en cargar
    public float getReloadTime() {
        return reloadTime;
    }

    //set para costo
    public void setSunCost(int sunCost) {
        this.sunCost = sunCost;
    }

}
