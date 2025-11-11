package Controller;

import Model.Daging;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Susu;
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

public class ProdukDagingController implements Initializable, ProdukReceiver {
    @FXML
    private TableColumn<Daging, Integer> ColIdDaging;
    @FXML
    private TableColumn<Daging, Double> ColBerat;
    @FXML
    private TableColumn<Daging, String> ColTanggalDipotong;
    @FXML
    private TableColumn<Daging, String> ColOptionDaging;
    @FXML
    private TableView<Daging> tvDaging;
    @FXML
    private Button ModalTambah;


    private ObservableList<Daging> dataDaging =  FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataDaging.add(new Daging(3, 12.12, "30-1-2001", "Daging"));
        dataDaging.add(new Daging(4, 5.6, "21-1-2001", "Daging"));

        ColIdDaging.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColBerat.setCellValueFactory(new PropertyValueFactory<>("berat"));
        ColTanggalDipotong.setCellValueFactory(new PropertyValueFactory<>("tanggal_dipanen"));
        //ColOptionDaging.setCellValueFactory(new PropertyValueFactory<>("OptionDaging"));

        tvDaging.setItems(dataDaging);
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
    public void addDaging(Daging daging) {
        dataDaging.add(daging);
        tvDaging.refresh();
    }

    @Override
    public void addSusu(Susu susu) {}

    @Override
    public void addTelur(Telur telur) {}
}