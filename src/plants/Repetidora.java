package plants;

import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class Repetidora extends LanzaGisante {
    private boolean plantInGame = false;

    //constructor
    public Repetidora(int column, int row, Board board, LinkedList<Entity> listClassification) {
        super(column,row,board,listClassification);
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
