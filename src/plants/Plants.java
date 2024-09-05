package plants;

import Entity.Entity;

public abstract class Plants extends Entity {
    //atributos

    private int sunCost;
    private float reloadTime; //timepo que demora en volver a cargar
    private float missingTime; //este tiempo tiene que disminuir hasta llegar a 0 para que se pueda volver a usar

    //constructor
    public Plants(String name,int healt, int column, int row, int sunCost, float reloadTime, float missingTime) {
        super(healt,name,column,row);
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

    public void takeDamage(int damage) {//el demage es el del zombie
        this.setLife(this.getLife()-damage); //le resto a la vida actual el daño que hace el zombie
        if (getLife() <= 0) {
            // la planta muere si su salud es menor o igual a 0
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
