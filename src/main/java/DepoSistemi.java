import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DepoSistemi {
    Scanner scan=new Scanner(System.in);

    static int urunId = 0;
    static ArrayList<HashMap<Integer, PojoUrun>> list = new ArrayList<>();


    public void urunTanimlama(ArrayList<HashMap<Integer,PojoUrun>> list) {


            System.out.println("Lutfen urun ismi giriniz.");
            String urunIsmi=scan.nextLine();
            System.out.println("Lutfen uretici giriniz.");
            String uretici=scan.nextLine();
            System.out.println("Lutfen birim giriniz.");
            String birim=scan.nextLine();

            int id =idTanimlama();
            HashMap<Integer, PojoUrun> map = new HashMap<>();

            PojoUrun urun = new PojoUrun(id,urunIsmi,uretici,birim);


            map.put(id, urun);
            list.add(map);


        }


        public  int idTanimlama() {


            if (urunId == 0) {

                urunId = 1;

            } else {

                urunId += 1;

            }
            return urunId;


        }



    public static void urunListele() {
        //Bu metot, tanımlanan ürünleri listelemek için kullanılacaktır.
        // Ürünlerin id, isim, üretici, miktar, birim ve raf bilgileri görüntülenecektir.
        // Eğer ürünün miktarı veya raf bilgisi tanımlanmamışsa, varsayılan değerler kullanılacaktır.

    }

    public static void urunGirisi() {

    }

    public static void urunuRafaKoy() {

    }

    public static void urunCikisi() {

    }

}
