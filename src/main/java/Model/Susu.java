package Model;

public class Susu extends Produk {
    private final String tipe = "Susu";
    private double liter;

    public Susu(int id, double liter, String tanggal_dipanen, String tipe) {
        super(id, tipe, tanggal_dipanen);
        this.setTipe(tipe);
        this.liter = liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }
    public double getLiter() {
        return liter;
    }
}
