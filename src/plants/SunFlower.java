package plants;

//definicion  de la subclase Sunflower
public class SunFlower extends Plants {
    private int generateSuns; //25 soles
    private int generationTime; //cada  25 segundos
    private boolean plantInPlay; //para ver si hay algun girasol en juego y despues poder poner el birasol

    //constructor llamo a la super clase y cargo  los valores
    public SunFlower(int x, int y) {
        super("Sun Flower",100, x, y, 50, 4, 4);
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

    public String getInfo(){
        return ("This plant is " + this.getName() + " - Position: (" + this.getX() + ", " + this.getY() + ") ");
    }

}

