import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DepoSistemi {
    Scanner scan = new Scanner(System.in);
    static int urunId = 0;
    static ArrayList<HashMap<Integer, PojoUrun>> list = new ArrayList<>();
    public void urunTanimlama(ArrayList<HashMap<Integer, PojoUrun>> list) {

        System.out.println("Lutfen urun ismi giriniz.");
        String urunIsmi = scan.nextLine();
        System.out.println("Lutfen uretici giriniz.");
        String uretici = scan.nextLine();
        System.out.println("Lutfen birim giriniz.");
        String birim = scan.nextLine();

        int id = idTanimlama();
        HashMap<Integer, PojoUrun> map = new HashMap<>();

        PojoUrun urun = new PojoUrun(id, urunIsmi, uretici, birim);

        map.put(id, urun);
        list.add(map);
        urunListele();

    }

    public int idTanimlama() {
        urunId = (urunId == 0) ? 1 : urunId + 1;
        return urunId;
    }


    public void urunListele() {

        System.out.println("id     ismi    ureticisi   miktar    birimi    raf");
        System.out.println("--------------------------------------------------");

        for (HashMap<Integer, PojoUrun> w : list) {
            for (PojoUrun each : w.values()) {

                System.out.printf("%-6s %-8s %-8s %-8s %-8s %-8s %n",
                        each.getId(), each.getUrunIsmi(), each.getUretici(),
                        each.getMiktar(), each.getBirim(), each.getRaf()
                );
            }
        }
    }

    public void urunGirisi(int id, int miktar) {

        int yeniMiktar;
        for (HashMap<Integer, PojoUrun> w : list) {
            for (Integer each : w.keySet()) {
                if (each == id) {
                    PojoUrun urun = w.get(id);
                    yeniMiktar = urun.getMiktar() + miktar;
                    urun.setMiktar(yeniMiktar);
                    urunListele();
                } else System.out.println("Ürün bulunamadı..");
            }

        }
    }

    public void urunCikisi(int id, int miktar) {

        int yeniMiktar;
        for (HashMap<Integer, PojoUrun> w : list) {
            for (Integer each : w.keySet()) {
                if (each == id) {
                    PojoUrun urun = w.get(id);
                    yeniMiktar = urun.getMiktar() - miktar;
                    if (yeniMiktar < 0) yeniMiktar = 0;
                    urun.setMiktar(yeniMiktar);
                    urunListele();

                } else System.out.println("Ürün bulunamadı..");
            }
        }
    }

    public void urunRafaKoy(int id, String raf) {

        for (HashMap<Integer, PojoUrun> w : list) {
            for (Integer each : w.keySet()) {
                if (each == id) {
                    PojoUrun urun = w.get(id);
                    urun.setRaf(raf);
                    urunListele();
                } else System.out.println("Ürün bulunamadı..");
            }
        }
    }

}
