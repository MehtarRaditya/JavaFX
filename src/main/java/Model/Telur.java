package Model;

public class Telur extends Produk {
    private final String tipe = "Telur";
    private int butir;

    public Telur(int id, int butir, String tanggal_dipanen, String tipe) {
        super(id, tipe, tanggal_dipanen);
        this.setTipe(tipe);
        this.butir = butir;
    }

    public void setButir(int butir) {
        this.butir = butir;
    }
    public int getButir() {
        return butir;
    }
}
