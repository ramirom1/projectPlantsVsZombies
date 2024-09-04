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
        LanzaGisante gisante = new LanzaGisante(1,1);
        Zombie zom = new Zombie(1);

        System.out.println(zom.getPositionX()+","+zom.getPositionY());
        System.out.println(gisante.getPositionX()+","+gisante.getPositionY());
        tablero.board[gisante.getPositionX()][gisante.getPositionY()].add(gisante);
        tablero.board[zom.getPositionX()][zom.getPositionY()].add(zom);

        System.out.println(zom.getLife());

        gisante.attack(tablero);

        System.out.println(zom.getLife());

        tablero.printBoard();
        }

    }