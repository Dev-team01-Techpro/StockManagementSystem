import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        starter();
    }


    public static void starter() {
        Scanner scan = new Scanner(System.in);

        DepoSistemi depo = new DepoSistemi();

        boolean dongu = true;

        while (dongu) {

            DepoSistemi.fontColor("MENü", "yellow");
            DepoSistemi.fontColor("-".repeat(50), "blue");
            DepoSistemi.fontColor("1- Ürün tanımla", "green");
            DepoSistemi.fontColor("2- Ürün listeleme", "green");
            DepoSistemi.fontColor("3- Ürün girişi", "green");
            DepoSistemi.fontColor("4- Ürünü rafa koy", "green");
            DepoSistemi.fontColor("5- Ürün çıkışı", "green");
            DepoSistemi.fontColor("0- Çıkış", "red");

            int secim = scan.nextInt();

            switch (secim) {
                case 1:
                    depo.urunTanimlama(DepoSistemi.list);
                    break;
                case 2:
                    depo.urunListele("ÜRÜN LİSTESİ"); //burda titel yazicaz demissiniz o kismi anlamadim.Testerlar baksin.
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
                case 0:
                    dongu = false;
                    break;
                default:
                    DepoSistemi.fontColor("Yanlış işlem yaptınız. Lütfen tekrar deneyin!","red");
                    break;
            }


        }


    }


}
