package Entity;

public abstract class Entity {
    private int life;
    private String name;
    private int positionX, positionY;

    public Entity(int life, String name, int positionX, int positionY) {
        this.life = life;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //Getters & setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
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

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
