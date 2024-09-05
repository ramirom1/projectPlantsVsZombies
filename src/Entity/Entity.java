package Entity;

public abstract class Entity {
    private int life;
    private String name;
    private int column, row;

    public Entity(int life, String name, int column, int row) {
        this.life = life;
        this.name = name;
        this.column = column;
        this.row = row;
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
}
