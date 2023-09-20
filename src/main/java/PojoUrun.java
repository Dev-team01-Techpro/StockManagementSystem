public class PojoUrun {

    private int id;
    private String urunIsmi;
    private String uretici;
    private int miktar = 0;
    private String birim;
    private String raf = "-" ;


    public PojoUrun(){

    }

    public PojoUrun(int id, String urunIsmi, String uretici, String birim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getUrunIsmi() {

        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {

        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {

        return uretici;
    }

    public void setUretici(String uretici) {

        this.uretici = uretici;
    }

    public int getMiktar() {

        return miktar;
    }

    public void setMiktar(int miktar) {

        this.miktar = miktar;
    }

    public String getBirim() {

        return birim;
    }

    public void setBirim(String birim) {

        this.birim = birim;
    }

    public String getRaf() {

        return raf;
    }

    public void setRaf(String raf) {

        this.raf = raf;
    }
}
