import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DepoSistemi {
    // ANSI renk kodları
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

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
        System.out.println();

        int id = idTanimlama();
        HashMap<Integer, PojoUrun> map = new HashMap<>();

        PojoUrun urun = new PojoUrun(id, urunIsmi, uretici, birim);

        map.put(id, urun);
        list.add(map);
        urunListele("ÜRÜNLER");

    }

    public int idTanimlama() {
        urunId = (urunId == 0) ? 1 : urunId + 1;
        return urunId;
    }


    public void urunListele(String title) {

        fontColor(title, "green");
        fontColor("id     ismi    ureticisi   miktar    birimi    raf", "yellow");
        fontColor("-".repeat(50), "blue");

        for (HashMap<Integer, PojoUrun> w : list) {
            for (PojoUrun each : w.values()) {

                System.out.printf("%-6s %-8s %-11s %-8d %-9s %s%n",
                        each.getId(), each.getUrunIsmi(), each.getUretici(),
                        each.getMiktar(), each.getBirim(), each.getRaf()
                );
            }
        }
        fontColor("*".repeat(50), "red");
    }

    public void urunGirisi(int id, int miktar) {

        int yeniMiktar;
        for (HashMap<Integer, PojoUrun> w : list) {
            for (Integer each : w.keySet()) {
                if (each == id) {
                    PojoUrun urun = w.get(id);
                    yeniMiktar = urun.getMiktar() + miktar;
                    urun.setMiktar(yeniMiktar);
                    urunListele("ÜRÜNLER GİRİŞİ");
                } else fontColor("Ürün bulunamadı..", "red");
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
                    urunListele("ÜRÜNLER ÇIKIŞI");

                } else fontColor("Ürün bulunamadı..", "red");
            }
        }
    }

    public void urunRafaKoy(int id, String raf) {

        for (HashMap<Integer, PojoUrun> w : list) {
            for (Integer each : w.keySet()) {
                if (each == id) {
                    PojoUrun urun = w.get(id);
                    urun.setRaf(raf);
                    urunListele("ÜRÜNLER RAFLAMA");
                } else fontColor("Ürün bulunamadı..", "red");
            }
        }
    }

    public static void fontColor(String text, String color){
        String renkKodu = RESET;

        switch (color.toLowerCase()) {
            case "red":
                renkKodu = RED;
                break;
            case "green":
                renkKodu = GREEN;
                break;
            case "yellow":
                renkKodu = YELLOW;
                break;
            case "blue":
                renkKodu = BLUE;
                break;
            default:
                break;
        }
        System.out.println(renkKodu + text + RESET);
    }
}
