package game;//es na matriz que tiene almacenada las plantas, zombies y proyectiles
import Entity.Entity;

import java.util.*;

import plants.*;
import zombie.*;

/**
 * Encargada de representar al tablero del juego y contener información acerca de las entidades en juego
 */
public class Board {
    private final int COL = 10, FILAS = 5;
    private int counterRepetidora, counterGirasol, counterPatatapum;
    public List<Entity>[][] board;

    /**
     * Crea un tablero con una LinkedList de tipo entidad por cada casillero
     */
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

    /**
     * Elimina una entidad de una posición del tablero
     * @param entity Entidad que se busca eliminar
     * @param x Fila donde se encuentra la entidad
     * @param y Columna donde se encuentra la entidad
     */
    public void removeEntity(Entity entity, int x, int y) {
        if (x >= 0 && x < FILAS && y >= 0 && y < COL) {
            board[x][y].remove(entity);  // Remueve la entidad de la lista en la posición (x, y)

        }
    }

    /**
     * Busca una lista, que contiene entidades, en una posicion del tablero y la retorna
     * @param x Fila donde se encuentra la entidad
     * @param y Columna donde se encuentra la entidad
     * @return La lista que se encuentra en la posicion del tablero introducida
     */
    public List<Entity> getEntitiesAt(int x, int y) {
        if (x >= 0 && x < FILAS && y >= 0 && y < COL) {
            List<Entity> listSorted = board[x][y];
            return getOrderedEntities(listSorted);
        } else {
            throw new IndexOutOfBoundsException("Posición fuera de los límites del tablero.");
        }

    }

    /**
     * Imprime por pantalla el tablero del juego
     */
    public void printBoard() {
        for (int i = 0; i < FILAS; i++) {
            // Imprimir número de fila antes de cada fila
            System.out.print("Fila" + (i + 1) + " "); // Ajusta para tener al menos 6 caracteres de ancho

            for (int j = 0; j < COL; j++) {
                List<Entity> entities = board[i][j];
                String cellContent = "";

                if (entities.isEmpty()) {
                    cellContent = "      "; // Celda vacía, 6 espacios
                } else {
                    StringBuilder contentBuilder = new StringBuilder();
                    for (Entity entity : entities) {
                        if (entity instanceof Birasol) {
                            contentBuilder.append("Bi ");
                        } else if (entity instanceof Girasol) {
                            contentBuilder.append("G ");
                        } else if (entity instanceof Guisantralladora) {
                            contentBuilder.append("Gt ");
                        } else if (entity instanceof Repetidora) {
                            contentBuilder.append("R ");
                        } else if (entity instanceof HielaGuisante) {
                            contentBuilder.append("H ");
                        } else if (entity instanceof LanzaGuisante) {
                            contentBuilder.append("La ");
                        } else if (entity instanceof Gasoseta) {
                            contentBuilder.append("Gs ");
                        } else if (entity instanceof Patatapum) {
                            contentBuilder.append("Pp ");
                        }
                        // Zombies
                        else if (entity instanceof Nuez) {
                            contentBuilder.append("N ");
                        } else if (entity instanceof Petacereza) {
                            contentBuilder.append("Cz ");
                        } else if (entity instanceof ZombieSaltador) {
                            contentBuilder.append("J ");
                        } else if (entity instanceof ZombieLector) {
                            contentBuilder.append("L ");
                        } else if (entity instanceof ZombieCaracono) {
                            contentBuilder.append("Cc ");
                        } else if (entity instanceof ZombieCaracubo) {
                            contentBuilder.append("Cq ");
                        } else if (entity instanceof ZombieAbanderado) {
                            contentBuilder.append("A ");
                        } else if (entity instanceof Zombie) {
                            contentBuilder.append("Z ");
                        } else {
                            contentBuilder.append("? "); // Entidad desconocida
                        }
                    }

                    cellContent = contentBuilder.toString().trim(); // Remover espacios adicionales
                    if (cellContent.length() > 6) {
                        cellContent = cellContent.substring(0, 6); // Limitar a 6 caracteres si se excede
                    } else {
                        while (cellContent.length() < 6) {
                            cellContent += " "; // Completar con espacios si es menor a 6 caracteres
                        }
                    }
                }

                System.out.print("[" + cellContent + "]"); // Celda con el contenido ajustado
            }
            System.out.println(); // Nueva línea después de cada fila
        }

        // Imprimir números de columna después de las filas
        System.out.print("     "); // Espacio inicial para alinear con los números de fila
        for (int j = 0; j < COL; j++) {
            System.out.print("   Col" + (j + 1) + " "); // Ajusta para tener al menos 6 caracteres de ancho
        }
        System.out.println(); // Salto de línea después de los números de columna
    }


    // Método para obtener una lista ordenada de entidades

    /**
     * Ordena las entidades de una lista, dejando en la primer posición a las plantas
     * @param entities Lista que se busca ordenar
     * @return Lista ordenada
     */
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
