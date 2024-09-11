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
        HielaGuisante cereza = new HielaGuisante(7,0,tablero,aggrPlants);
        Zombie zom1 = new Zombie(0,tablero,listZombie);
        Zombie zom2 = new Zombie(0,tablero,listZombie);
        Zombie zom3 = new Zombie(0,tablero,listZombie);

        aggrPlants.add(cereza);
        listZombie.add(zom1);

        System.out.println(cereza.getLife() + "vida PLANTA antes del ataque");
        System.out.println(cereza.getSlowDown() + " EL ATAQUE RELENTIZA");

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

        System.out.println(zom1.getLife() + "vida ZOMBIE 1 antes del ataque");
        System.out.println(zom2.getLife() + "vida ZOMBIE 2 antes del ataque");
        System.out.println(zom3.getLife() + "vida ZOMBIE 3 antes del ataque");

        cereza.attack(tablero);
        //cereza.attack(tablero);



        //zom.attack(tablero);
        System.out.println(cereza.getLife());
        tablero.printBoard();
        System.out.println(aggrPlants);
        System.out.println(listZombie);
        System.out.println(zom1.getLife() + "vida ZOMBIE 1 DESPUES del ataque");
        System.out.println(zom2.getLife() + "vida ZOMBIE 2 DESPUES del ataque");
        System.out.println(zom3.getLife() + "vida ZOMBIE 3 DESPUES del ataque");
        System.out.println(tablero.getEntitiesAt(0,9));

        }


    }