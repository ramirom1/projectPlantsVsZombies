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
    private static int currentRound = 1, totalSuns = 500;
    private static boolean continueGame = true;
    static Random random = new Random();


    public static void main(String[] args) {
        gameBoard.printBoard();
        while(continueGame){
            if ((currentRound % 3) != 0){collectSuns(nonAggrPlants);}

            //realizar movimientos
            moveRound();

            System.out.println("Cantidad de Soles: " + totalSuns);

            //Desplegar tienda del locura Dave
            if ((currentRound % 10) == 0){shop();}

            //Desplegar menu de plantas
            System.out.println("¿Desea plantar alguna aliada? (S/N)");
            if (Character.toLowerCase(scanner.next().charAt(0)) == 's'){plant();}

            // spawnear zombies
            spawnZombies();

            //realizar ataques
            attackRound();

            // mover zombies
            moveRound();

            //printBoard
            gameBoard.printBoard();

            currentRound++;
        }
        System.out.println("Juego finalizado");
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

            //Modificar ints de board
            switch (plantNum) {
                case 1:
                    if (totalSuns >= 50) {
                        plantType = new Girasol(1, 1, gameBoard, nonAggrPlants);
                        nonAggrPlants.add(plantType);
                        totalSuns -= 50;
                        gameBoard.setCounterGirasol(gameBoard.getCounterGirasol()+1);
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
                        gameBoard.setCounterRepetidora(gameBoard.getCounterRepetidora()+1);
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 6:
                    if (totalSuns >= 25) {
                        plantType = new Patatapum(1, 1, gameBoard, aggrPlants);
                        aggrPlants.add(plantType);
                        totalSuns -= 25;
                        gameBoard.setCounterPatatapum(gameBoard.getCounterPatatapum()+1);
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

    public static void spawnZombies() {
        Zombie zombieType = null;
        for (int i = 0; i <= random.nextInt(4); i++) {
            switch (random.nextInt(6)) {
                case 0:
                    zombieType = new Zombie(random.nextInt(5), gameBoard, zombiesInBoard);
                    break;
                case 1:
                    zombieType = new ZombieAbanderado(random.nextInt(5), gameBoard, zombiesInBoard);
                    break;
                case 2:
                    zombieType = new ZombieCaracono(random.nextInt(5), gameBoard, zombiesInBoard);
                    break;
                case 3:
                    zombieType = new ZombieCaracubo(random.nextInt(5), gameBoard, zombiesInBoard);
                    break;
                case 4:
                    zombieType = new ZombieLector(random.nextInt(5), gameBoard, zombiesInBoard);
                    break;
                case 5:
                    zombieType = new ZombieSaltador(random.nextInt(5), gameBoard, zombiesInBoard);
                    break;
            }
            gameBoard.board[zombieType.getRow()][zombieType.getColumn()].add(zombieType);
            zombiesInBoard.add(zombieType);
        }
    }

    /* IDEA PARA CONGELAR ZOMBIE
        Cuando vamos a mover a los zombies, me fijo en speed y en un contador de rondas que lleva congelado, si ese contador
        es igual a cierto parametro la velocidad vuelve a la normal (Habria que agregar un atributo de defaultSpeed y roundsFreezed)
        y cada vez que se lo ataca el contador vuelve a 0
    */

    public static void attackRound(){
        for (Entity entity : aggrPlants) {
            if (entity instanceof Guisantralladora){
                ((Guisantralladora) entity).attack(gameBoard);
            }
            else if (entity instanceof Repetidora){
                ((Repetidora) entity).attack(gameBoard);
            }
            else if (entity instanceof Petacereza){
                ((Petacereza) entity).attack(gameBoard);
            }
            else if (entity instanceof Gasoseta){
                ((Gasoseta) entity).attack(gameBoard);
            }
            else if (entity instanceof Patatapum){
                ((Patatapum) entity).attack(gameBoard);
            }
            else if (entity instanceof HielaGuisante){
                ((HielaGuisante) entity).attack(gameBoard);
            }
            else if (entity instanceof LanzaGisante) {
                ((LanzaGisante) entity).attack(gameBoard);
            }
            else if (entity instanceof Zombie){
                ((Zombie) entity).attack(gameBoard);
            }
        }

    }

    public static void moveRound(){
        for (Entity zomb : zombiesInBoard){
            int speed = ((Zombie) zomb).getSpeed();

            // Si llegamos al final se termina el juego
            if (zomb.getColumn() == 0){
                continueGame = false;
                break;
            //Si no, se mueven los zombies
            } else if (zomb instanceof ZombieSaltador) {
                Entity checkPlantExist = null;
                if (!gameBoard.board[zomb.getRow()][zomb.getColumn() - 1].isEmpty()){
                    checkPlantExist = gameBoard.board[zomb.getRow()][zomb.getColumn()-1].get(0);
                }
                if (checkPlantExist instanceof Plants && (zomb.getColumn()-2) >= 0){
                    gameBoard.board[zomb.getRow()][zomb.getColumn()].remove(zomb);
                    gameBoard.board[zomb.getRow()][zomb.getColumn()-2].add(zomb);
                    zomb.setColumn(zomb.getColumn()-2);
                } else {
                    moveZombie(zomb);
                }
            }  else {
                //Verificamos si es velocidad lenta y se mueve turno por medio
                if (speed == 0){
                    if (currentRound % 4 == 0){
                        moveZombie(zomb);
                    }
                }
                //Si es velocidad rapida se mueve todas las rondas
                else if (speed == 2){
                    moveZombie(zomb);
                }
                //Si no es velocidad normal
                else{
                    if (currentRound % 2 == 0){
                        moveZombie(zomb);
                    }
                }
            }
        }
    }

    public static void moveZombie(Entity zomb){
        Entity firstEnt = gameBoard.board[zomb.getRow()][zomb.getColumn()].get(0);
        if (firstEnt instanceof Zombie) {
            gameBoard.board[zomb.getRow()][zomb.getColumn()].remove(zomb);
            gameBoard.board[zomb.getRow()][zomb.getColumn()-1].add(zomb);
            zomb.setColumn(zomb.getColumn()-1);
        }
    }

    public static void shop(){
        System.out.println("EYEYEY AQUÍ CRAZY DAVE,¿No quieres mejorar alguna aliada? (S/N)");
        if (Character.toLowerCase(scanner.next().charAt(0)) == 's') {
            System.out.println("Planta               Coste");
            System.out.println("1- Birasol            150");
            System.out.println("2- Guisantralladora   250");
            System.out.println("3- Gasoseta           150");

            int choice = scanner.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println("Opción no válida, elige nuevamente");
                choice = scanner.nextInt();
            }

            String basePlant = null;
            Plants upgradedPlant = null;
            switch (choice) {
                case 1: // Birasol
                    if (totalSuns >= 150) {
                        if (gameBoard.getCounterGirasol() > 0){
                            upgradedPlant = new Birasol(1,1, gameBoard, nonAggrPlants);
                            basePlant = "Girasol";
                            totalSuns -= 150;
                        } else {
                            System.out.println("No hay ningun girasol en el tablero");
                            return;
                        }
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 2: // Guisantralladora
                    if (totalSuns >= 250) {
                        if (gameBoard.getCounterRepetidora() > 0){
                            upgradedPlant = new Guisantralladora(1,1, gameBoard, aggrPlants);
                            basePlant = "Guisantralladora";
                            totalSuns -= 250;
                        } else {
                            System.out.println("No hay ninguna repetidora en el tablero");
                            return;
                        }
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 3: // Gasoseta
                    if (totalSuns >= 150) {
                        if (gameBoard.getCounterPatatapum() > 0){
                            upgradedPlant = new Gasoseta(1, 1, gameBoard, aggrPlants);
                            basePlant = "Gasoseta";
                            totalSuns -= 150;
                        } else {
                            System.out.println("No hay ninguna patatapum en el tablero");
                            return;
                        }
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }


            if (upgradedPlant != null) {
                // Pedir la fila y columna
                boolean changePos = false;

                do {
                    System.out.println("Indique la fila donde quiere implementar la mejora: ");
                    int rowToPlant = scanner.nextInt();
                    while (rowToPlant < 1 || rowToPlant > 5) {
                        System.out.println("Fila fuera de rango, ingrese nuevamente");
                        rowToPlant = scanner.nextInt();
                    }

                    System.out.println("Indique la columna donde quiere implementar la mejora: ");
                    int columnToPlant = scanner.nextInt();
                    while (columnToPlant < 1 || columnToPlant > 10) {
                        System.out.println("Columna fuera de rango, ingrese nuevamente");
                        columnToPlant = scanner.nextInt();
                    }

                    if (Objects.equals(gameBoard.board[rowToPlant - 1][columnToPlant - 1].get(0).getName(), basePlant)) {
                        gameBoard.board[rowToPlant - 1][columnToPlant - 1].removeIf(basePlantDel -> basePlantDel instanceof Plants);
                        //asignarle la fila y columna a la planta
                        upgradedPlant.setRow(rowToPlant - 1);
                        upgradedPlant.setColumn(columnToPlant - 1);
                        // Colocar la planta en el tablero
                        gameBoard.board[rowToPlant - 1][columnToPlant - 1].add(upgradedPlant);
                        changePos = false;
                    } else {
                        System.out.println("La plante base no coincide con su mejora. Escoja una posición válida");
                        changePos = true;
                    }
                } while (changePos);
            }
            scanner.nextLine();
        }
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
