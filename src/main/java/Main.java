import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ArrayList<HashMap<Integer, PojoUrun>> list = new ArrayList<>();
        DepoSistemi depo = new DepoSistemi();



        depo.urunTanimlama(list);

    }

}
