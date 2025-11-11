package Controller;

import Model.Daging;
import Model.Susu;
import Model.Telur;

public interface ProdukReceiver {
    void addSusu(Susu susu);
    void addDaging(Daging daging);
    void addTelur(Telur telur);
}
