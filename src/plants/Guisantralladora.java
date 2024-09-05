package plants;

public class Guisantralladora extends Repetidora{

    //constructor
    public Guisantralladora(int column,int row){
        super(column,row);
        this.setDemage(400);
        this.setName("Guisantralladora");
        this.setSunCost(250);
        this.setPlantInGame(false);
        //falta lo del tiempo
    }
}
