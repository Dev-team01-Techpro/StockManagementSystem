import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        DepoSistemi depo = new DepoSistemi();

        depo.urunTanimlama(DepoSistemi.list);

        depo.urunGirisi(1,100);

        depo.urunGirisi(1,500);

        depo.urunCikisi(1,1000);

        depo.urunRafaKoy(1,"ananas");


    }

}
