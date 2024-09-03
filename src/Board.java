//es na matriz que tiene almacenada las plantas, zombies y proyectiles
import Entity.Entity;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Board {
    private final int COL = 10, FILAS = 5;
    private boolean existsRepetidora, existsGirasol, existsPatatapum;
    public List<Entity>[][] board;

    public Board(){
        this.existsRepetidora = false;
        this.existsGirasol = false;
        this.existsPatatapum = false;
        board = new List[5][10];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                board[i][j] = new LinkedList<Entity>();
            }
        }
    }

    public void move(int oldX, int oldY, int newX, int newY){
        this.board[newX][newY] = new LinkedList<Entity>(this.board[oldX][oldY]);
        this.board[oldX][oldY].clear();
    }

    public void printBoard(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (List<Entity>[] fila : this.board){
            System.out.println("                                                          ");
            for (List<Entity> list : fila){
                if (!list.isEmpty()) {
                    String summary = getSummary(list);
                    System.out.print("|" + summary);
                } else {
                    System.out.print("|" + " ".repeat(20)); // Utiliza espacios para llenar la celda vacía
                }
            }
            System.out.println("|");
            System.out.println("-------------------------------------------------------------");
        }
    }

    // Método para generar un resumen de los elementos en una lista
    private String getSummary(List<Entity> list) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Entity entity : list) {
            String typeName = entity.getClass().getSimpleName();
            countMap.put(typeName, countMap.getOrDefault(typeName, 0) + 1);
        }

        StringBuilder summary = new StringBuilder();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                summary.append(entry.getKey()).append("(x").append(entry.getValue()).append(") ");
            } else {
                summary.append(entry.getKey()).append(" ");
            }
        }

        return summary.toString().trim();
    }
}
