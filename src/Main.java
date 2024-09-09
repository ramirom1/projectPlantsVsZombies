import plants.Birasol;
import plants.Girasol;
import game.Board;
import plants.LanzaGisante;
import plants.Plants;
import zombie.Zombie;
import Entity.Entity;

import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList<Entity> aggrPlants = new LinkedList<Entity>();
        LinkedList<Entity> nonAggrPlants = new LinkedList<Entity>();
        LinkedList<Entity> listZombie = new LinkedList<Entity>();
        Board tablero = new Board();
        LanzaGisante gisante = new LanzaGisante(9,0,tablero,aggrPlants);
        Zombie zom = new Zombie(0,tablero,listZombie);

        aggrPlants.add(gisante);
        listZombie.add(zom);

        System.out.println(gisante.getLife() + "vida PLANTA antes del ataque");
        System.out.println(zom.getLife() + "vida ZOMBIE antes del ataque");

        //System.out.println(zom.getColumn()+","+zom.getRow());
        //System.out.println(gisante.getColumn()+","+gisante.getRow());
        tablero.board[gisante.getRow()][gisante.getColumn()].add(gisante); // hay un problema con los x e y
        tablero.board[zom.getRow()][zom.getColumn()].add(zom);

        System.out.println(aggrPlants);
        System.out.println(listZombie);

        System.out.println(zom.getLife());
        tablero.printBoard();
        gisante.attack(tablero);

        System.out.println(zom.getLife());


        //zom.attack(tablero);
        System.out.println(gisante.getLife());
        tablero.printBoard();
        System.out.println(aggrPlants);
        System.out.println(listZombie);

        }

    }