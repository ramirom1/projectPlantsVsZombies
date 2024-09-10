package game;
import Entity.Entity;
import plants.*;
import zombie.*;
import java.util.Random;

import java.util.*;

//maneja el juego (turnos, quita de vida,etc)
public class Game {
    private static LinkedList<Entity> aggrPlants = new LinkedList<Entity>();
    private static LinkedList<Entity> nonAggrPlants = new LinkedList<Entity>();
    private static LinkedList<Entity> zombiesInBoard = new LinkedList<Entity>();
    private static LinkedList<Entity> zombiesToSpawn = new LinkedList<Entity>();
    private static Scanner scanner = new Scanner(System.in);
    private static Board gameBoard = new Board();
    private static int currentRound = 0, totalSuns = 500;
    private static boolean continueGame = true;
    static Random random = new Random();


    public static void main(String[] args) {
        while(continueGame){
            if ((currentRound % 2) != 0){
                collectSuns(nonAggrPlants);
            }
            System.out.println("Cantidad de Soles: " + totalSuns);
            gameBoard.printBoard();
            //Desplegar menu de plantas
            System.out.println("¿Desea plantar alguna aliada? (S/N)");
            char answer = Character.toLowerCase(scanner.next().charAt(0));
            if (answer == 's'){
                plant();
            }

            // spawnear zombies
            spawnZombies();

            //realizar ataques
            attackRound();

            // Aquí continuar con la ronda de ataque y movimiento
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

    public static void plant() {
        boolean continuePlanting = true;
        while (continuePlanting) {
            System.out.println("Indique que planta quiere ubicar");
            int plantNum = choosePlant();

            // Determinar el tipo de planta basado en el costo
            Plants plantType = null;

            switch (plantNum) {
                case 1:
                    if (totalSuns >= 50) {
                        plantType = new Girasol(1, 1, gameBoard, nonAggrPlants);
                        nonAggrPlants.add(plantType);
                        totalSuns -= 50;
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 2:
                    if (totalSuns >= 100) {
                        plantType = new LanzaGisante(1, 1, gameBoard, aggrPlants);
                        aggrPlants.add(plantType);
                        totalSuns -= 100;
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 3:
                    if (totalSuns >= 50) {
                        plantType = new Nuez(1, 1, gameBoard, nonAggrPlants);
                        nonAggrPlants.add(plantType);
                        totalSuns -= 50;
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 4:
                    if (totalSuns >= 175) {
                        plantType = new HielaGuisante(1, 1, gameBoard, aggrPlants);
                        aggrPlants.add(plantType);
                        totalSuns -= 175;
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 5:
                    if (totalSuns >= 150) {
                        plantType = new Repetidora(1, 1, gameBoard, aggrPlants);
                        aggrPlants.add(plantType);
                        totalSuns -= 150;
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 6:
                    if (totalSuns >= 25) {
                        plantType = new Patatapum(1, 1, gameBoard, aggrPlants);
                        aggrPlants.add(plantType);
                        totalSuns -= 25;
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 7:
                    if (totalSuns >= 150) {
                        plantType = new Petacereza(1, 1, gameBoard, aggrPlants);
                        aggrPlants.add(plantType);
                        totalSuns -= 150;
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                default:
                    System.out.println("El número ingresado es inválido");
                    break;
            }

            if (plantType != null) {
                // Pedir la fila y columna
                boolean changePos = false;

                do {
                    System.out.println("Indique la fila: ");
                    int rowToPlant = scanner.nextInt();
                    while (rowToPlant < 1 || rowToPlant > 5) {
                        System.out.println("Fila fuera de rango, ingrese nuevamente");
                        rowToPlant = scanner.nextInt();
                    }

                    System.out.println("Indique la columna: ");
                    int columnToPlant = scanner.nextInt();
                    while (columnToPlant < 1 || columnToPlant > 10) {
                        System.out.println("Columna fuera de rango, ingrese nuevamente");
                        columnToPlant = scanner.nextInt();
                    }

                    if (!containsPlant(gameBoard.board[rowToPlant - 1][columnToPlant - 1])) {
                        //asignarle la fila y columna a la planta
                        plantType.setRow(rowToPlant - 1);
                        plantType.setColumn(columnToPlant - 1);
                        // Colocar la planta en el tablero
                        gameBoard.board[rowToPlant - 1][columnToPlant - 1].add(plantType);
                        changePos = false;
                    } else {
                        System.out.println("Esa posicion ya está ocupada, ingrese otra distinta");
                        changePos = true;
                    }
                } while (changePos);
            }

            scanner.nextLine();

            System.out.println("¿Desea plantar nuevamente? (S/N)");
            if (Character.toLowerCase(scanner.nextLine().charAt(0)) != 's') {
                System.out.println("Pasando a la siguiente ronda");
                continuePlanting = false;
            }
        }
    }


    public static boolean containsPlant(List<Entity> list){
        for (Entity entity : list) {
            if (entity instanceof Plants) {
                return true;
            }
        }
        return false;
    }

    public static void spawnZombies(){
        Zombie zombieType = null;
        for (int i = 0; i <= random.nextInt(4); i++) {
            switch (random.nextInt(6)) {
                case 0:
                    zombieType = new Zombie(random.nextInt(5), gameBoard, zombiesInBoard);
                case 1:
                    zombieType = new ZombieAbanderado(random.nextInt(5), gameBoard, zombiesInBoard);
                case 2:
                    zombieType = new ZombieCaracono(random.nextInt(5), gameBoard, zombiesInBoard);
                case 3:
                    zombieType = new ZombieCaracubo(random.nextInt(5), gameBoard, zombiesInBoard);
                case 4:
                    zombieType = new ZombieLector(random.nextInt(5), gameBoard, zombiesInBoard);
                case 5:
                    zombieType = new ZombieSaltador(random.nextInt(5), gameBoard, zombiesInBoard);
            }
            gameBoard.board[zombieType.getRow()][zombieType.getColumn()].add(zombieType);
        }
    }

    public static void attackRound(){
        for (Entity entity : aggrPlants) {
            if (entity instanceof LanzaGisante) {
                ((LanzaGisante) entity).attack(gameBoard); // Llama al método attack
            }
        }
    }

    public void moveRound(){
    }

    public void shop(){
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
        int answer = scanner.nextInt();
        while (answer < 1 || answer > 7) {
            System.out.println("Opcion no valida, ingrese nuevamente");
            answer = scanner.nextInt();
        }
        return answer;
    }
}
