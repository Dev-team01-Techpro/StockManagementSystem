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

        System.out.println("Lütfen ürün adı giriniz.");
        String urunIsmi = scan.nextLine();
        System.out.println("Lütfen üretici giriniz.");
        String uretici = scan.nextLine();
        System.out.println("Lütfen birim giriniz.");
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
        fontColor("ID     Ürün Adı    Üretici   Miktar    Birimi    Raf", "yellow");
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

    public void urunGirisi() {
        try {
            System.out.println("Lütfen ID giriniz.");
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Ürün miktar giriniz.");
            int miktar = Integer.parseInt(scan.nextLine());

            int yeniMiktar;
            for (HashMap<Integer, PojoUrun> w : list) {
                for (Integer each : w.keySet()) {
                    if (each == id) {
                        PojoUrun urun = w.get(id);
                        yeniMiktar = urun.getMiktar() + miktar;
                        urun.setMiktar(yeniMiktar);
                        urunListele("ÜRÜN GİRİŞİ");
                        return;
                    }
                }
            }
            fontColor("Ürün bulunamadı..", "red");
        } catch (NumberFormatException e) {
            System.err.println("Hatalı giriş! ID ve miktar tam sayı olmalıdır.");
        }


    }

    public void urunCikisi() {
        try {
            System.out.println("Lütfen ID giriniz.");
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Miktar giriniz.");
            int miktar = Integer.parseInt(scan.nextLine());

            int yeniMiktar;
            for (HashMap<Integer, PojoUrun> w : list) {
                for (Integer each : w.keySet()) {
                    if (each == id) {
                        PojoUrun urun = w.get(id);
                        yeniMiktar = urun.getMiktar() - miktar;
                        if (yeniMiktar < 0) yeniMiktar = 0;
                        urun.setMiktar(yeniMiktar);
                        urunListele("ÜRÜN ÇIKIŞI");
                        return;
                    }
                }
            }
            fontColor("Ürün bulunamadı..", "red");
        } catch (NumberFormatException e) {
            System.err.println("Hatalı giriş! ID ve miktar tam sayı olmalıdır.");
        }
    }

    public void urunRafaKoy() {
        try {
            System.out.println("Lütfen ID giriniz.");
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Lütfen raf bilgisini giriniz.");
            String raf = scan.nextLine();

            for (HashMap<Integer, PojoUrun> w : list) {
                for (Integer each : w.keySet()) {
                    if (each == id) {
                        PojoUrun urun = w.get(id);
                        urun.setRaf(raf);
                        urunListele("ÜRÜN RAFLAMA");
                        return;
                    }
                }
            }
            fontColor("Ürün bulunamadı!", "red");
        } catch (NumberFormatException e) {
            System.err.println("Hatalı giriş! ID ve miktar tam sayı olmalıdır.");
        }
    }

    public static void fontColor(String text, String color) {

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
