package Controller;

import Model.Daging;
import Model.Susu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Telur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProdukSusuController implements Initializable, ProdukReceiver {
    @FXML
    private TableColumn<Susu, Integer> ColIdSusu;
    @FXML
    private TableColumn<Susu, Double> ColLiter;
    @FXML
    private TableColumn<Susu, String> ColTanggalDiperah;
    @FXML
    private TableColumn<Susu, String> ColOptionSusu;
    @FXML
    private TableView<Susu> tvSusu;
    @FXML
    private Button ModalTambah;

    private ObservableList<Susu> dataSusu = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataSusu.add(new Susu(1, 2.1, "1-1-2001", "Susu"));
        dataSusu.add(new Susu(2, 5.1, "2-1-2001", "Susu"));

        ColIdSusu.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColLiter.setCellValueFactory(new PropertyValueFactory<>("liter"));
        ColTanggalDiperah.setCellValueFactory(new PropertyValueFactory<>("tanggal_dipanen"));
        //ColOptionSusu.setCellValueFactory(new PropertyValueFactory<>("OptionSusu"));

        tvSusu.setItems(dataSusu);
    }

    @FXML
    public void Susu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ProdukSusu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Telur(ActionEvent event) throws IOException {}{

    }

    @FXML
    public void Daging(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ProdukDaging.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ModalTambah(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddProduk.fxml"));
            Parent root = loader.load();

            TambahProdukController modalController = loader.getController();
            modalController.setReceiver(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSusu(Susu susu) {
        dataSusu.add(susu);
        tvSusu.refresh();
    }

    @Override
    public void addDaging(Daging daging) {
        // tidak digunakan di sini
    }

    @Override
    public void addTelur(Telur telur) {}
}