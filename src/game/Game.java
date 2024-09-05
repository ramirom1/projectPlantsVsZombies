package game;
import Entity.Entity;
import plants.*;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

//maneja el juego (turnos, quita de vida,etc)
public class Game {
    private LinkedList<Entity> aggrPlants = new LinkedList<Entity>();
    private static LinkedList<Entity> nonAggrPlants = new LinkedList<Entity>();
    private LinkedList<Entity> zombiesInBoard = new LinkedList<Entity>();
    private LinkedList<Entity> zombiesToSpawn = new LinkedList<Entity>();
    private static Scanner scanner = new Scanner(System.in);
    private static Board gameBoard = new Board();
    private static int currentRound = 0, totalSuns = 50;
    private static boolean continueGame = true;


    public static void main(String[] args) {
        while(continueGame){
            if ((currentRound % 2) != 0){
                collectSuns(nonAggrPlants);
            }
            System.out.println("Cantidad de Soles: " + totalSuns);
            gameBoard.printBoard();
            //Desplegar menu de plantas
            System.out.println("¿Desea plantar alguna aliada más? (S/N)");
            char answer = Character.toLowerCase(scanner.next().charAt(0));
            if (answer == 's'){
                /// Todo esto se podria implementar en un metodo aparte

                System.out.println("Indique que planta quiere ubicar");
                int plantNum = choosePlant();
                System.out.println("Indique la fila: ");
                int rowToPlant = scanner.nextInt();
                System.out.println("Indique la columna: ");
                // guardar columna
                int columnToPlant = scanner.nextInt();
                Entity plantType = null;

                //hacer switch-case
                switch (plantNum){
                    case 1:
                        if (totalSuns >= 50){
                            plantType = new Girasol(columnToPlant,rowToPlant);
                        }
                        else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    case 2:
                        if (totalSuns >= 100) {
                            plantType = new LanzaGisante(columnToPlant, rowToPlant);
                        }
                        else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    case 3:
                        if (totalSuns >= 50) {
                            plantType = new Nuez(columnToPlant, rowToPlant);
                        }
                        else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    case 4:
                        if (totalSuns >= 175) {
                            plantType = new HielaGuisante(columnToPlant, rowToPlant);
                        }
                        else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    case 5:
                        if (totalSuns >= 150) {
                            plantType = new Repetidora(columnToPlant, rowToPlant);
                        }
                        else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    case 6:
                        if (totalSuns >= 25) {
                            plantType = new Patatapum(columnToPlant, rowToPlant);
                        }
                        else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    case 7:
                        if (totalSuns >= 150) {
                            plantType = new Petacereza(columnToPlant, rowToPlant);
                        }
                        else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    default:
                        System.out.println("El número ingresado es inválido");
                        break;
                }

                if (plantType != null){
                    gameBoard.board[rowToPlant][columnToPlant].add(plantType);
                }

            }
            // llamar a attack (hay que implementarlo)
            //llamar a move (hay que implementarlo)

            currentRound++;
        }
    }

    //Por cada girasol o birasol se suman 25 o 50 soles
    public static void collectSuns(LinkedList<Entity> nonAggrPlants) {
        int i = 0;
        while (i < nonAggrPlants.size()) {
            if (Objects.equals(nonAggrPlants.get(i).getName(), "Girasol")){
                totalSuns += 25;
            }
            else if (Objects.equals(nonAggrPlants.get(i).getName(), "Birasol")){
                totalSuns += 50;
            }
            i++;
        }
    }

    public void attackRound(){
    }

    public void moveRound(){
    }

    public static int choosePlant(){
        System.out.println("Planta              Coste");
        System.out.println("1- Girasol          50");
        System.out.println("2- LanzaGuisantes   100");
        System.out.println("3- Nuez             50");
        System.out.println("4- HielaGuisante    175");
        System.out.println("5- Repetidora       150");
        System.out.println("6- Patatapum        25");
        System.out.println("7- Petacereza       150");
        return scanner.nextInt();
    }
}
