//es na matriz que tiene almacenada las plantas, zombies y proyectiles
import Entity.Entity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int COL = 10, FILAS = 5;
    private boolean existsRepetidora, existsGirasol, existsPatatapum;
    public List<Entity>[][] board;

    public Board(){
        this.existsRepetidora = false;
        this.existsGirasol = false;
        this.existsPatatapum = false;
        board = new List[5][10];
    }

    public void move(int oldX, int oldY, int newX, int newY){

    }

    public void printBoard(){

    }
}
