package plants;

import Entity.Attack;
import Entity.Entity;
import game.Board;
import zombie.Zombie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Petacereza extends Plants implements Attack {
    private int radio;
    private int demage;

    //constructor
    public Petacereza(int column,int row,Board board, LinkedList<Entity> listClassification) {
        super("Petacereza",600,column,row,150,1,1,board,listClassification);
        this.radio = 1;
        this.demage = 1500;

    }

    ///SOLO ELIMINA EL PRIMER ZOMBIE
    //metodo que hace la explosion
    public void attack(Board board) {
        // Explosión en un área de 3x3 alrededor de la Petacereza
        int row = this.getRow();
        int column = this.getColumn();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < board.getRows() && j >= 0 && j < board.getCols()) {
                    // Obtener la lista de entidades en la posición actual
                    List<Entity> entities = board.getEntitiesAt(i, j);
                    entities.removeIf(entity -> entity instanceof Plants);
                    // Iterar sobre todas las entidades en esta casilla

                    for (int k = 0; k < entities.size(); k++) {

                        Entity entity = entities.get(k);

                        // Verificar si la entidad es un Zombie antes de aplicar el daño
                        ((Zombie) entity).takeDamage(this.getDemage());  // Aplicar daño al zombie
                    }
                }
            }
        }
        // Eliminar la Petacereza después de atacar
        board.removeEntity(this, row, column);
        //la eliminamos de la lista de plantas agresivas
        removeEntityList(this);
    }


    public int getRadio() {
        return radio;
    }
    public int getDemage() {
        return demage;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }
}
