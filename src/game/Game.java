package game;
import Entity.Entity;
import plants.*;
import zombie.*;
import java.util.Random;
import java.util.*;

//maneja el juego (turnos, quita de vida,etc)

/**
 * Es la encargada de gestionar la jugabilidad, desde donde se va a ejecutar el proyecto
 */
public class Game {
    private static LinkedList<Entity> aggrPlants = new LinkedList<Entity>();
    private static LinkedList<Entity> nonAggrPlants = new LinkedList<Entity>();
    private static LinkedList<Entity> zombiesInBoard = new LinkedList<Entity>();
    private static Scanner scanner = new Scanner(System.in);
    private static Board gameBoard = new Board();
    private static int currentRound = 0, totalSuns = 50;
    private static boolean continueGame = true;
    private static Random random = new Random();


    public static void main(String[] args) {
        System.out.println("Comienza el juego");
        System.out.println("Tablero inicial");
        gameBoard.printBoard();
        while(continueGame){
            if ((currentRound % 3) != 0){collectSuns(nonAggrPlants);}

            //realizar movimientos
            moveRound();

            System.out.println("Ronda: " + (currentRound+1));
            System.out.println("Cantidad de soles: " + totalSuns);

            //Desplegar tienda del Dave
            if (((currentRound + 1) % 10) == 0){shop();}

            //Desplegar menu de plantas
            if (currentRound % 2 == 0){
                System.out.println("¿Desea plantar alguna aliada? (S/N)");
                if (Character.toLowerCase(scanner.next().charAt(0)) == 's'){plant();}
            }

            // spawnear zombies
            if (currentRound > 2){
                if (currentRound % 2 == 1){
                    spawnZombies();
                }
            }

            //realizar ataques
            attackRound();

            //printBoard
            if (currentRound % 2 == 1 && currentRound > 2){System.out.println("Se mueven los zombies");}
            gameBoard.printBoard();

            // mover zombies

            moveRound();

            System.out.println(" ");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println(" ");
            currentRound++;
            if (currentRound == 30){
                continueGame = false;
                System.out.println("FELICIDADES!!! LOS ZOMBIES HAN SIDO DERROTADOS");}
        }
        System.out.println("Juego finalizado");
    }

    /**
     * Su función es sumar soles al contador totalSuns, 25 por cada girasol y 50 por cada Birasol
     * @param nonAggrPlants Lista de plantas no agresivas
     */
    //Por cada girasol o birasol se suman 25 o 50 soles
    public static void collectSuns(LinkedList<Entity> nonAggrPlants) {
        int sunsCounter = 0;
        for (Entity nonAggroPlant : nonAggrPlants){
            if (nonAggroPlant instanceof Birasol){
                sunsCounter += ((Birasol) nonAggroPlant).generateSuns();
            } else if (nonAggroPlant instanceof Girasol){
                sunsCounter += ((Girasol) nonAggroPlant).generateSuns();
            }
        }
        totalSuns += sunsCounter;
        System.out.println("Se han recolectado " + sunsCounter + " soles");
    }

    /**
     * Va a preguntarle al jugador si desea plantar alguna planta, y en caso de obtener una respuesta positiva
     * la agrega al tablero
     */
    public static void plant() {
        boolean continuePlanting = true;
        while (continuePlanting) {
            System.out.println("Cantidad de soles: " + totalSuns);
            System.out.println("Indique qué planta quiere ubicar");

            int plantNum = -1;
            // Solicitar la planta
            try {
                plantNum = choosePlant();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();  // Limpiar el buffer del scanner
                continue;
            }

            Plants plantType = null;

            // Modificar ints de board
            switch (plantNum) {
                case 1:
                    if (totalSuns >= 50) {
                        plantType = new Girasol(1, 1, gameBoard, nonAggrPlants);
                        nonAggrPlants.add(plantType);
                        totalSuns -= 50;
                        gameBoard.setCounterGirasol(gameBoard.getCounterGirasol() + 1);
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 2:
                    if (totalSuns >= 100) {
                        plantType = new LanzaGuisante(1, 1, gameBoard, aggrPlants);
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
                        gameBoard.setCounterRepetidora(gameBoard.getCounterRepetidora() + 1);
                    } else {
                        System.out.println("No tienes suficientes soles");
                    }
                    break;
                case 6:
                    if (totalSuns >= 25) {
                        plantType = new Patatapum(1, 1, gameBoard, aggrPlants);
                        aggrPlants.add(plantType);
                        totalSuns -= 25;
                        gameBoard.setCounterPatatapum(gameBoard.getCounterPatatapum() + 1);
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
                    int rowToPlant = -1;
                    int columnToPlant = -1;

                    try {
                        System.out.println("Indique la fila: ");
                        rowToPlant = scanner.nextInt();
                        while (rowToPlant < 1 || rowToPlant > 5) {
                            System.out.println("Fila fuera de rango, ingrese nuevamente");
                            rowToPlant = scanner.nextInt();
                        }

                        System.out.println("Indique la columna: ");
                        columnToPlant = scanner.nextInt();
                        while (columnToPlant < 1 || columnToPlant > 10) {
                            System.out.println("Columna fuera de rango, ingrese nuevamente");
                            columnToPlant = scanner.nextInt();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Debes ingresar un número.");
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        changePos = true;
                        continue;  // Reintentar
                    }

                    if (!containsPlant(gameBoard.board[rowToPlant - 1][columnToPlant - 1])) {
                        // Asignar la fila y columna a la planta
                        plantType.setRow(rowToPlant - 1);
                        plantType.setColumn(columnToPlant - 1);
                        // Colocar la planta en el tablero
                        gameBoard.board[rowToPlant - 1][columnToPlant - 1].add(0, plantType);
                        changePos = false;
                        gameBoard.printBoard();
                    } else {
                        System.out.println("Esa posición ya está ocupada, ingrese otra distinta");
                        changePos = true;
                    }
                } while (changePos);
            }

            scanner.nextLine();  // Limpiar el buffer del scanner

            try {
                System.out.println("¿Desea plantar nuevamente? (S/N)");
                if (Character.toLowerCase(scanner.nextLine().charAt(0)) != 's') {
                    System.out.println("Pasando a la siguiente ronda");
                    continuePlanting = false;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Entrada inválida. No se ingresó ninguna letra.");
                continuePlanting = false;
            }
        }
    }

    /**
     * Indica si, en la lista pasada como argumento, existe una instancia de planta
     * @param list Lista que pertenece al tablero (gameBoard)
     * @return true si hay una planta en la lista, caso contrario retorna false
     */
    public static boolean containsPlant(List<Entity> list){
        for (Entity entity : list) {
            if (entity instanceof Plants) {
                return true;
            }
        }
        return false;
    }

    /**
     * Se encarga de la generación aleatoria de zombies
     */
    public static void spawnZombies() {
        Zombie zombieType = null;
        int upperBound = random.nextInt(2)+1;
        if (((currentRound + 4) % 4) == 1){
            ZombieAbanderado zombAband = new ZombieAbanderado(random.nextInt(5),gameBoard, zombiesInBoard);
            gameBoard.board[zombAband.getRow()][zombAband.getColumn()].add(zombAband);
            zombiesInBoard.add(zombAband);
            upperBound = random.nextInt(3) + 3;
            zombAband.setInvasion();
        }// 40 zombie, 25 cc, 15 cq, 10 jumper y lector
        for (int i = 0; i <= upperBound; i++) {
            int randomIndex = random.nextInt(20);
            if (randomIndex < 10){
                zombieType = new Zombie(random.nextInt(5), gameBoard, zombiesInBoard);
            } else if (randomIndex < 15){
                zombieType = new ZombieCaracono(random.nextInt(5), gameBoard, zombiesInBoard);
            } else if(randomIndex < 17){
                zombieType = new ZombieCaracubo(random.nextInt(5), gameBoard, zombiesInBoard);
            } else if(randomIndex < 18){
                zombieType = new ZombieSaltador(random.nextInt(5), gameBoard, zombiesInBoard);
            } else{
                zombieType = new ZombieLector(random.nextInt(5), gameBoard, zombiesInBoard);
            }
            gameBoard.board[zombieType.getRow()][zombieType.getColumn()].add(zombieType);
            zombiesInBoard.add(zombieType);
        }
    }

    /**
     * Realiza la ronda de ataque de las entidades agresivas
     */
    public static void attackRound(){
        for (Entity plant : aggrPlants) {
            if (plant instanceof Guisantralladora){
                ((Guisantralladora) plant).attack(gameBoard);
            }
            else if (plant instanceof Repetidora){
                ((Repetidora) plant).attack(gameBoard);
            }
            else if (plant instanceof Petacereza){
                ((Petacereza) plant).attack(gameBoard);
            }
            else if (plant instanceof Gasoseta){
                ((Gasoseta) plant).attack(gameBoard);
            }
            else if (plant instanceof Patatapum){
                if (((Patatapum) plant).getRoundsSincePlanted() == 5){
                    ((Patatapum) plant).attack(gameBoard);
                } else {
                    ((Patatapum) plant).setRoundsSincePlanted(((Patatapum) plant).getRoundsSincePlanted() + 1);
                }
            }
            else if (plant instanceof HielaGuisante){
                ((HielaGuisante) plant).attack(gameBoard);
            }
            else if (plant instanceof LanzaGuisante) {
                ((LanzaGuisante) plant).attack(gameBoard);
            }
        }
        for (Entity zombie : zombiesInBoard){
            if (zombie instanceof Zombie){
                ((Zombie) zombie).attack(gameBoard);
            }
        }

    }

    /**
     * Realiza la ronda de los movimientos de los zombies
     */
    public static void moveRound(){
        for (Entity zomb : zombiesInBoard){
            int speed = ((Zombie) zomb).getSpeed();

            // Si llegamos al final se termina el juego
            if (zomb.getColumn() == 0 && !containsPlant(gameBoard.board[zomb.getRow()][zomb.getColumn()])){
                System.out.println("Un zombie ha alcanzado tu base. ¡Has sido derrotado!");
                continueGame = false;
                break;
            //Si no, se mueven los zombies
            } else if (zomb instanceof ZombieSaltador) {
                if (currentRound % 2 == 1) {
                    Entity checkPlantExist = null;
                    if (zomb.getColumn()-1 >= 0){
                        if (!gameBoard.board[zomb.getRow()][zomb.getColumn() - 1].isEmpty()) {
                            checkPlantExist = gameBoard.board[zomb.getRow()][zomb.getColumn() - 1].get(0);
                        }
                    }
                    if (checkPlantExist instanceof Plants && (zomb.getColumn() - 2) >= 0 && speed == 2) {
                        gameBoard.board[zomb.getRow()][zomb.getColumn()].remove(zomb);
                        gameBoard.board[zomb.getRow()][zomb.getColumn() - 2].add(zomb);
                        zomb.setColumn(zomb.getColumn() - 2);
                        ((ZombieSaltador) zomb).setSpeed(1);
                    } else {
                        moveZombie(zomb);
                    }
                }
            }  else {
                //Verificamos si es velocidad lenta y se mueve turno por medio
                if (speed == 0){
                    if (currentRound % 6 == 1){
                        moveZombie(zomb);
                    }
                }
                //Si es velocidad rapida se mueve todas las rondas
                else if (speed == 2 && currentRound % 2 == 1){
                    moveZombie(zomb);
                }
                //Si no es velocidad normal
                else{
                    if (currentRound % 4 == 1){
                        moveZombie(zomb);
                    }
                }
            }
        }
    }

    /**
     * Mueve un zombie una casilla delante siempre que no esté sobre una planta
     * @param zomb Zombie que va a ser movido
     */
    public static void moveZombie(Entity zomb){
        if (!containsPlant(gameBoard.board[zomb.getRow()][zomb.getColumn()])) {
            gameBoard.board[zomb.getRow()][zomb.getColumn()].remove(zomb);
            gameBoard.board[zomb.getRow()][zomb.getColumn()-1].add(zomb);
            zomb.setColumn(zomb.getColumn()-1);
            // si cantidadDeRondas congelado es igual a 4, le cambiamos la velocidad, si no, le aumentamos el contador
            if (((Zombie) zomb).getTotalFreezedRounds() == 4){
                ((Zombie) zomb).setSpeed(1);
                ((Zombie) zomb).setTotalFreezedRounds(0);
            } else {
                ((Zombie) zomb).setTotalFreezedRounds(((Zombie) zomb).getTotalFreezedRounds()+1);
            }
        }
    }

    /**
     * Despliega la tienda de Crazy Dave y realiza la mejora elegida en caso de que hayan suficientes soles
     * y exista el tipo de planta base necesario
     */
    public static void shop() {
        System.out.println("EYEYEY AQUI CRAZY DAVE, ¿No quieres mejorar alguna aliada? (S/N)");

        try {
            if (Character.toLowerCase(scanner.next().charAt(0)) == 's') {
                System.out.println("Planta               Coste");
                System.out.println("1- Birasol            150");
                System.out.println("2- Guisantralladora   250");
                System.out.println("3- Gasoseta           150");

                int choice = -1;
                boolean validInput = false;
                do {
                    try {
                        choice = scanner.nextInt();
                        if (choice >= 1 && choice <= 3) {
                            validInput = true;
                        } else {
                            System.out.println("Opción no válida, elige nuevamente");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Debe ingresar un número.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                } while (!validInput);

                String basePlant = null;
                Plants upgradedPlant = null;
                switch (choice) {
                    case 1: // Birasol
                        if (totalSuns >= 150) {
                            if (gameBoard.getCounterGirasol() > 0) {
                                upgradedPlant = new Birasol(1, 1, gameBoard, nonAggrPlants);
                                basePlant = "Girasol";
                                totalSuns -= 150;
                            } else {
                                System.out.println("No hay ningún girasol en el tablero");
                                return;
                            }
                        } else {
                            System.out.println("No tienes suficientes soles");
                        }
                        break;
                    case 2: // Guisantralladora
                        if (totalSuns >= 250) {
                            if (gameBoard.getCounterRepetidora() > 0) {
                                upgradedPlant = new Guisantralladora(1, 1, gameBoard, aggrPlants);
                                basePlant = "Repetidora";
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
                            if (gameBoard.getCounterPatatapum() > 0) {
                                upgradedPlant = new Gasoseta(1, 1, gameBoard, aggrPlants);
                                basePlant = "Patatapum";
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
                        int rowToPlant = -1;
                        int columnToPlant = -1;
                        boolean validPosition = false;

                        do {
                            try {
                                System.out.println("Indique la fila donde quiere implementar la mejora: ");
                                rowToPlant = scanner.nextInt();
                                if (rowToPlant >= 1 && rowToPlant <= 5) {
                                    validPosition = true;
                                } else {
                                    System.out.println("Fila fuera de rango, ingrese nuevamente");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Debe ingresar un número.");
                                scanner.nextLine(); // Limpiar buffer
                            }
                        } while (!validPosition);

                        validPosition = false;
                        do {
                            try {
                                System.out.println("Indique la columna donde quiere implementar la mejora: ");
                                columnToPlant = scanner.nextInt();
                                if (columnToPlant >= 1 && columnToPlant <= 10) {
                                    validPosition = true;
                                } else {
                                    System.out.println("Columna fuera de rango, ingrese nuevamente");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Debe ingresar un número.");
                                scanner.nextLine(); // Limpiar buffer
                            }
                        } while (!validPosition);

                        String targetName;
                        if (gameBoard.board[rowToPlant - 1][columnToPlant - 1].size() == 0){
                            targetName = null;
                        } else{
                            targetName = gameBoard.board[rowToPlant - 1][columnToPlant - 1].get(0).getName();
                        }

                        if (Objects.equals(targetName, basePlant)) {
                            gameBoard.board[rowToPlant - 1][columnToPlant - 1].removeIf(basePlantDel -> basePlantDel instanceof Plants);
                            upgradedPlant.setRow(rowToPlant - 1);
                            upgradedPlant.setColumn(columnToPlant - 1);
                            gameBoard.board[rowToPlant - 1][columnToPlant - 1].add(0, upgradedPlant);
                            changePos = false;
                        } else {
                            System.out.println("La planta base no coincide con su mejora. Escoja una posición válida");
                            changePos = true;
                        }
                    } while (changePos);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Operación cancelada.");
            scanner.nextLine(); // Limpiar buffer en caso de excepción
        }
        scanner.nextLine();
    }

    /**
     * Despliega el menú para elegir una planta
     * @return El número de planta elegido
     */
    public static int choosePlant() {
        int answer = -1;
        boolean validInput = false;

        // Imprimir la lista de plantas y sus costos
        System.out.println("Planta              Coste");
        System.out.println("1- Girasol          50");
        System.out.println("2- LanzaGuisantes   100");
        System.out.println("3- Nuez             50");
        System.out.println("4- HielaGuisante    175");
        System.out.println("5- Repetidora       150");
        System.out.println("6- Patatapum        25");
        System.out.println("7- Petacereza       150");

        // Bucle para pedir la opción de planta
        do {
            try {
                System.out.println("Ingrese el número correspondiente a la planta que desea elegir: ");
                answer = scanner.nextInt();

                // Validar que esté dentro del rango permitido
                if (answer >= 1 && answer <= 7) {
                    validInput = true;  // Si la opción es válida, salimos del bucle
                } else {
                    System.out.println("Opción no válida, ingrese nuevamente");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine();  // Limpiar el buffer del scanner
            }
        } while (!validInput);  // Repetir hasta obtener una opción válida

        return answer;
    }
}
