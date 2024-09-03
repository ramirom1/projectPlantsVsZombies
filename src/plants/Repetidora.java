package plants;

public class Repetidora extends LanzaGisante {
    private boolean plantInGame = false;

    //constructor
    public Repetidora(int x, int y) {
        super(x,y);
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
