package plants;

public class Guisantralladora extends Repetidora{

    //constructor
    public Guisantralladora(int x,int y){
        super(x,y);
        this.setDemage(400);
        this.setName("Guisantralladora");
        this.setSunCost(250);
        this.setPlantInGame(false);
        //falta lo del tiempo
    }
}
