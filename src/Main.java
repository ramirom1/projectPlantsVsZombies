import plants.Birasol;
import plants.Girasol;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //prueba de plants.SunFlower
        Girasol p1 = new Girasol(1,1);
        System.out.println(p1.getSun());
        Birasol p2 = new Birasol(2,2);
        System.out.println(p2.getSun());
        }

    }