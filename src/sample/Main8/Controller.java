package sample.Main8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;



public class Controller {
    @FXML
    private TextField height;

    public void submit(ActionEvent event){
        String chieucao = this.height.getText();
        Alert.AlertType alertAlertType;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("chieu cao cua ban " + chieucao + " cm");
        alert.show();
    }

}
