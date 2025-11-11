package Model;

public class Daging extends Produk {
    private final String tipe = "Daging";
    private double berat;

    public Daging(int id, double berat, String tanggal_dipanen, String tipe) {
        super(id, tipe, tanggal_dipanen);
        this.setTipe(tipe);
        this.berat = berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }
    public double getBerat() {
        return berat;
    }
}
