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

    }

    //metodo para saber si esta disponible  para usar(si ya cargo)
    public boolean available() {
        if (this.missingTime == 0) {
            return true; //retorna true si el tiempo es 0, hay que ver como lo hacemos disminuir
        } else{
            return false;//retorna false si todavia no se termina el tiempo de espera
        }
    }
}
