package Controller;

import Model.Daging;
import Model.Susu;
import Model.Telur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdukController implements Initializable {
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

    private ObservableList<Daging> dataDaging =  FXCollections.observableArrayList();
    private ObservableList<Susu> dataSusu =   FXCollections.observableArrayList();
    private ObservableList<Telur> dataTelur =   FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataDaging.add(new Daging(3, 12.12, "1-1-2001", "Daging"));
        dataDaging.add(new Daging(4, 5.6, "2-1-2001", "Daging"));

        dataSusu.add(new Susu(1, 2.1, "1-1-2001", "Susu"));
        dataSusu.add(new Susu(2, 5.1, "2-1-2001", "Susu"));

        ColIdSusu.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColLiter.setCellValueFactory(new PropertyValueFactory<>("liter"));
        ColTanggalDiperah.setCellValueFactory(new PropertyValueFactory<>("tanggal_dipanen"));
        ColOptionSusu.setCellValueFactory(new PropertyValueFactory<>("OptionSusu"));

        tvSusu.setItems(dataSusu);
    }
}