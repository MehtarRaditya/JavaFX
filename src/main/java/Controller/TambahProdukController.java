package Controller;

import Model.Daging;
import Model.Susu;
import Model.Telur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TambahProdukController implements Initializable, ProdukReceiver {

    @FXML
    private ChoiceBox<String> Jenis;

    @FXML
    private TextField Jumlah;

    @FXML
    private DatePicker Tanggal;

    private String[] produk = {"Susu", "Telur", "Daging"};

    private ProdukReceiver receiver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Jenis.getItems().addAll(produk);
    }

    @FXML
    private void TambahProduk(ActionEvent event) {
        int id = 4;
        String jenis = Jenis.getSelectionModel().getSelectedItem().toString();
        String jumlahTxt = Jumlah.getText();
        String tanggal = Tanggal.getValue().toString();

        id += 1;

        if (jenis == null || tanggal == null || jumlahTxt == null) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Semua Input Harus Terisi!");
            return;
        }

        if (jenis.equals("Susu")) {
            double jumlah = Double.parseDouble(jumlahTxt);
            Susu susu = new Susu(id, jumlah, tanggal, jenis);
            receiver.addSusu(susu);
        }
        else if (jenis.equals("Telur")) {

        }
        else if (jenis.equals("Daging")) {
            double jumlah = Double.parseDouble(jumlahTxt);
            Daging daging = new Daging(id, jumlah, tanggal, jenis);
            receiver.addDaging(daging);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setReceiver(ProdukReceiver receiver) {
        this.receiver = receiver;
    }

    @FXML
    private void Batal(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void addSusu(Susu susu) {

    }

    @Override
    public void addDaging(Daging daging) {

    }

    @Override
    public void addTelur(Telur telur) {

    }
}

