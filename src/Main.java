import plants.Birasol;
import plants.Girasol;
import game.Board;
import plants.LanzaGisante;
import plants.Plants;
import zombie.Zombie;
import Entity.Entity;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Board tablero = new Board();
        LanzaGisante gisante = new LanzaGisante(3,0);
        Zombie zom = new Zombie(0);

        System.out.println(zom.getColumn()+","+zom.getRow());
        System.out.println(gisante.getColumn()+","+gisante.getRow());
        tablero.board[gisante.getRow()][gisante.getColumn()].add(gisante); // hay un problema con los x e y
        tablero.board[zom.getRow()][zom.getColumn()].add(zom);

        System.out.println(zom.getLife());

        gisante.attack(tablero);

        System.out.println(zom.getLife());

        tablero.printBoard();
        }

    }