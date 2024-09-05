package plants;

public class Repetidora extends LanzaGisante {
    private boolean plantInGame = false;

    //constructor
    public Repetidora(int column, int row) {
        super(column,row);
        this.plantInGame = true;
        this.setName("Repetidora");
        this.setDemage(200);
        this.setSunCost(200);

    }

    //set de si hay una planta en juego
    public void setPlantInGame(boolean vOF){
        plantInGame = vOF;
    }

    //get de si hay en juego
    public boolean getPlantInGame() {
        return plantInGame;
    }

}
