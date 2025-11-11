package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TambahProdukController implements Initializable {

    @FXML
    private ChoiceBox<String> Jenis;

    @FXML
    private TextField Jumlah;

    @FXML
    private DatePicker Tanggal;

    private String[] produk = {"Susu", "Telur", "Daging"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Jenis.getItems().addAll(produk);
    }
}

