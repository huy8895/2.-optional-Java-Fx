package sample.Main12.combobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ComboBox<String > comboBox;

    @FXML
    Label label;


    ObservableList<String> observableList = FXCollections.observableArrayList("java","php");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(observableList);

    }

    public void comboBoxChange(ActionEvent event){

        label.setText(comboBox.getValue());
    }
}
