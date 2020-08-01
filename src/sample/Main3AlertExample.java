package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main3AlertExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My Application");
        Button button = new Button();
        button.setText("Say Hello!");
        button.setOnAction(event -> {
            Alert.AlertType alertAlertType;
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Alert1 Tittle");
            alert1.setHeaderText("Alert1 Header");
            alert1.setContentText("Alert1 Content");

            ButtonType buttonYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert1.getButtonTypes().setAll(buttonYes,buttonNo);
            Optional<ButtonType> result = alert1.showAndWait();
            if (result.get().getButtonData() == ButtonBar.ButtonData.YES) {
                System.out.println("code for yes");
            } else if (result.get().getButtonData() == ButtonBar.ButtonData.NO) {
                System.out.println("code for yes");
            }
            String message = result.get().getText();
            Alert alert2 = new Alert(AlertType.INFORMATION);
            alert2.setTitle("alert 2");
            alert2.setHeaderText("alert2 header");
            alert2.setContentText(message);
            alert2.show();



        });


        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
