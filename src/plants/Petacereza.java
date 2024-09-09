package plants;

import Entity.Attack;
import Entity.Entity;
import game.Board;

import java.util.LinkedList;

public class Petacereza extends Plants implements Attack {
    private int radio;
    private int demage;

    //constructor
    public Petacereza(int column,int row,Board board, LinkedList<Entity> listClassification) {
        super("Petacereza",600,column,row,150,1,1,board,listClassification);
        this.radio = 1;
        this.demage = 1500;

    }

    //metodo que hace la explosion
    public void attack(Board board) {
        //que quite el daño
        //que se elimine del tablero
        System.out.println("¡¡BOOM!!");
    }

    public int getRadio() {
        return radio;
    }
    public int getDemage() {
        return demage;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }
}
