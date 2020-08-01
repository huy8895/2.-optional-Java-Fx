package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.plaf.nimbus.State;

public class Main2ButtonExample extends Application {
    Stage window;
    Scene scene1,scene2;
    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        //scene1
        Label label = new Label("welcome");
        Button button1 = new Button("goto");
        button1.setOnAction(event -> {
             window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label,button1  );
        Parent root;
        scene1 = new Scene(layout1,300,200);

        //scene2
        Button button2 = new Button("go back");
        button2.setOnAction(event -> {
            window.setScene(scene1);
        });
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,200,300);

        window.setScene(scene1);
        window.show();
    }
}
