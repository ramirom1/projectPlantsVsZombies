//definicion  de la subclase Sunflower
public class SunFlower extends Plants {
    private int generateSuns; //25 soles
    private int generationTime; //cada  25 segundos

    //constructor llamo a la super clase y cargo  los valores
    public SunFlower(int x, int y) {
        super("Sun Flower",100, x, y, 50, 4, 4);
        this.generateSuns = 25;
        this.generationTime = 25;
    }
}