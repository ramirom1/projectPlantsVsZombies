package plants;

public class Birasol extends Girasol {
    // Constructor
    public Birasol(int column, int row) {
        super(column, row);
        this.setName("Birasol");
        this.setSunCost(150);//
    }

    // Sobrescribimos el método generateSuns para generar el doble de soles
    @Override
    public int getSun() {
        return 50;
    }
}

