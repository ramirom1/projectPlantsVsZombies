package game;//es na matriz que tiene almacenada las plantas, zombies y proyectiles
import Entity.Entity;

import java.util.*;

import plants.Birasol;
import zombie.*;
import plants.Plants;

public class Board {
    private final int COL = 10, FILAS = 5;
    private int counterRepetidora, counterGirasol, counterPatatapum;
    public List<Entity>[][] board;

    public Board(){
        this.counterRepetidora = 0;
        this.counterGirasol = 0;
        this.counterPatatapum = 0;
        board = new List[5][10];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                board[i][j] = new LinkedList<Entity>();
            }
        }
    }

    //metodo para eliminar entidades del talbero
    public void removeEntity(Entity entity, int x, int y) {
        if (x >= 0 && x < FILAS && y >= 0 && y < COL) {
            board[x][y].remove(entity);  // Remueve la entidad de la lista en la posición (x, y)

        }
    }



    public List<Entity> getEntitiesAt(int x, int y) {
        if (x >= 0 && x < FILAS && y >= 0 && y < COL) {
            List<Entity> listSorted = board[x][y];
            return getOrderedEntities(listSorted);
        } else {
            throw new IndexOutOfBoundsException("Posición fuera de los límites del tablero.");
        }

    }
    public void printBoard() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COL; j++) {
                List<Entity> entities = board[i][j];
                if (entities.isEmpty()) {
                    System.out.print("[ ] "); // Celda vacía
                } else {
                    System.out.print("["); // Inicio de la celda con entidades
                    for (Entity entity : entities) {
                        if (entity instanceof Birasol){
                            System.out.print("Bi");
                        } else if (entity instanceof Plants) {
                            System.out.print("P"); // Representación para las plantas
                        } else if (entity instanceof ZombieSaltador) {
                            System.out.print("J");
                        } else if (entity instanceof ZombieLector) {
                            System.out.print("L");
                        } else if (entity instanceof ZombieCaracono) {
                            System.out.print("Cc");
                        } else if (entity instanceof ZombieCaracubo) {
                            System.out.print("Cq");
                        } else if (entity instanceof ZombieAbanderado) {
                            System.out.print("A");
                        }
                        else if (entity instanceof Zombie) {
                            System.out.print("Z "); // Representación para los zombies
                        }
                        else {
                            System.out.print("? "); // Representación para entidades desconocidas
                        }
                    }
                    System.out.print("] "); // Fin de la celda con entidades
                }
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }

    // Método para obtener una lista ordenada de entidades
    public static List<Entity> getOrderedEntities(List<Entity> entities) {
        // Crear una copia de la lista para no modificar la original
        List<Entity> sortedEntities = new ArrayList<>(entities);

        // Ordenar la lista con un comparador
        Collections.sort(sortedEntities, (e1, e2) -> {
            if (e1 instanceof Plants && e2 instanceof Zombie) {
                return -1; // e1 (Plant) debe ir antes de e2 (Zombie)
            } else if (e1 instanceof Zombie && e2 instanceof Plants) {
                return 1;  // e1 (Zombie) debe ir después de e2 (Plant)
            } else {
                return 0;  // Mantener el orden original para entidades del mismo tipo
            }
        });

        // Retornar la lista ordenada
        return sortedEntities;
    }


    //hacer los getters y setters
    public int getRows(){
        return this.FILAS;
    }
    public int getCols(){
        return this.COL;
    }
    public int getCounterRepetidora() {
        return this.counterRepetidora;
    }
    public int getCounterGirasol() {
        return this.counterGirasol;
    }
    public int getCounterPatatapum() {
        return this.counterPatatapum;
    }

    public void setCounterRepetidora(int existsRepetidora) {
        this.counterRepetidora = existsRepetidora;
    }
    public void setCounterGirasol(int existsGirasol) {
        this.counterGirasol = existsGirasol;
    }
    public void setCounterPatatapum(int existsPatatapum) {
        this.counterPatatapum = existsPatatapum;
    }


}
