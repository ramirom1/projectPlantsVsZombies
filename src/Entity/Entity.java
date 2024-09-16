package Entity;

import java.util.LinkedList;

/**
 * Agrupa las caracteristicas que tienen en comun las plantas y los zombies
 */
public abstract class Entity {
    private int life;
    private String name;
    private int column, row;
    private LinkedList<Entity> classificationEntity;

    /**
     * Constructor de la clase Entity
     * @param life Puntos de vida de la entidad
     * @param name Nombre de la entidad
     * @param column Columna en la que se encuentra
     * @param row Fila en la que se encuentra
     * @param classificationEntity  clasificación de la entidad
     */
    public Entity(int life, String name, int column, int row, LinkedList<Entity> classificationEntity) {
        this.life = life;
        this.name = name;
        this.column = column;
        this.row = row;
        this.classificationEntity = classificationEntity;
    }

    //Getters & setters
    public void setName(String name) {
        this.name = name;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /**
     * Remueve las entidades de la lista de clasificación
     * @param entity es la entidad a eliminar
     */
    public void removeEntityList(Entity entity) {
        this.classificationEntity.remove(entity);
    }


}
