import plants.*;
import game.Board;
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
        Petacereza cereza = new Petacereza(8,1,tablero,aggrPlants);
        Zombie zom1 = new Zombie(0,tablero,listZombie);
        Zombie zom2 = new Zombie(0,tablero,listZombie);
        Zombie zom3 = new Zombie(0,tablero,listZombie);

        aggrPlants.add(cereza);
        listZombie.add(zom1);

        System.out.println(cereza.getLife() + "vida PLANTA antes del ataque");
        System.out.println(zom1.getLife() + "vida ZOMBIE antes del ataque");

        //System.out.println(zom.getColumn()+","+zom.getRow());
        //System.out.println(gisante.getColumn()+","+gisante.getRow());
        tablero.board[cereza.getRow()][cereza.getColumn()].add(cereza); // hay un problema con los x e y
        tablero.board[zom1.getRow()][zom1.getColumn()].add(zom1);
        tablero.board[zom2.getRow()][zom2.getColumn()].add(zom2);
        tablero.board[zom3.getRow()][zom3.getColumn()].add(zom3);

        System.out.println(aggrPlants);
        System.out.println(listZombie);

        System.out.println(zom1.getLife());
        tablero.printBoard();
        cereza.attack(tablero);
        //cereza.attack(tablero);

        System.out.println(zom1.getLife());


        //zom.attack(tablero);
        System.out.println(cereza.getLife());
        tablero.printBoard();
        System.out.println(aggrPlants);
        System.out.println(listZombie);
        System.out.println(zom2.getLife() + "vida ZOMBIE DESPUES del ataque");
        System.out.println(tablero.getEntitiesAt(0,9));

        }


    }