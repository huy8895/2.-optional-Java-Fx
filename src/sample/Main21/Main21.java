package sample.Main21;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main21 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Student Manager");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
