import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


   starter();



    }


    public static void starter(){
        Scanner scan=new Scanner(System.in);

        DepoSistemi depo = new DepoSistemi();

        boolean dongu=true;

        while (dongu){

            System.out.println("Urun tanimlamak icin 1, urun listelemek icin 2, urun girisi icin 3,\n"+
                    "urun cikisi icin 4, urunu rafa koymak icin 5 ve cikis icin 6`ya basiniz.");

           int secim=scan.nextInt();

            switch (secim) {
                case 1:
                    depo.urunTanimlama(DepoSistemi.list);
                    break;
                case 2:
                    depo.urunListele(); //burda titel yazicaz demissiniz o kismi anlamadim.Testerlar baksin.
                    break;
                case 3:
                    depo.urunGirisi();
                    break;
                case 4:
                    depo.urunRafaKoy();
                    break;
                case 5:
                    depo.urunCikisi();
                    break;
                case 6:
                    dongu = false;
                    break;
            }


        }


    }



}
