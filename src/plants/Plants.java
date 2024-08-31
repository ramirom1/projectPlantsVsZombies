package plants;

public class Plants {
    //atributos
    private String name;
    private float health;
    private int positionX;
    private int positionY;
    private int sunCost;
    private float reloadTime; //timepo que demora en volver a cargar
    private float missingTime; //este tiempo tiene que disminuir hasta llegar a 0 para que se pueda volver a usar

    //constructor
    public Plants(String name,float healt, int positionX, int positionY, int sunCost, float reloadTime, float missingTime) {
        this.name = name;
        this.health = healt;
        this.positionX = positionX;
        this.positionY = positionY;
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

    //get name
    public String getName() {
        return name;
    }
    //get position
    public String getPosition() {
        return (positionX + ", "+ positionY);
    }
    //get position x
    public int getX() {
        return (positionX);
    }
    //get position y
    public int getY() {
        return (positionY);
    }
    //get health
    public float getHealth() {
        return health;
    }
    //get costo
    public int getSunCost() {
        return sunCost;
    }
    //get de tiempo que demora en cargar
    public float getReloadTime() {
        return reloadTime;
    }
}
