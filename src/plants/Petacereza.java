package plants;

import Entity.Attack;
import game.Board;

public class Petacereza extends Plants implements Attack {
    private int radio;
    private int demage;

    //constructor
    public Petacereza(int x,int y) {
        super("Petacereza",600,x,y,150,1,1);
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
