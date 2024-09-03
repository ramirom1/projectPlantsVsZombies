package plants;

//definicion  de la subclase Sunflower
public class Girasol extends Plants {
    protected int generateSuns; //25 soles
    private int generationTime; //cada  25 segundos
    private boolean plantInPlay = false; //para ver si hay algun girasol en juego y despues poder poner el birasol

    //constructor llamo a la super clase y cargo  los valores
    public Girasol(int x, int y) {
        super("Girasol",100, x, y, 50, 4, 4);
        this.generateSuns = 25;
        this.generationTime = 25;
        this.plantInPlay = true;
    }

    //metodo para ver si hay girasoles en juego
    public boolean plantInPlay() {
        return plantInPlay;
    }

    //metodo para generar sol
    public int getSun() {
        return this.generateSuns;
    }

    //gets

    //get de cuanto demora en dar un 25 soles
    public int getGenerationTime() {
        return this.generationTime;
    }


    //set

    public String getInfo(){
        return ("This plant is " + this.getName() + " - Position: (" + this.getPosition() + ", " + this.getPositionY() + ") ");
    }

}

