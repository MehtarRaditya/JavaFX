package Model;

public abstract class Produk {
    private int id;
    private String tipe;
    private String tanggal_dipanen;

    public Produk(int id, String tipe, String tanggal_dipanen) {
        this.id = id;
        this.tipe = tipe;
        this.tanggal_dipanen = tanggal_dipanen;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setTanggal_dipanen(String tanggal_dipanen) {
        this.tanggal_dipanen = tanggal_dipanen;
    }
    public String getTanggal_dipanen() {
        return tanggal_dipanen;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    public String getTipe() {
        return tipe;
    }
}
