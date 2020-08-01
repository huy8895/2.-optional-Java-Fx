package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main5CheckBox extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("Programming language");
        CheckBox checkBox1 = new CheckBox("Java");
        CheckBox checkBox2 = new CheckBox("C#");
        CheckBox checkBox3 = new CheckBox("Php");

        checkBox1.setSelected(true);

        Button button = new Button("Submit");
        button.setOnAction(event -> {
            String message = "your language: ";
            if (checkBox1.isSelected())
                message += checkBox1.getText() + " ";
            if (checkBox2.isSelected())
                message += checkBox2.getText() + " ";
            if (checkBox3.isSelected())
                message += checkBox3.getText() + " ";
            System.out.println(message);
        });

        HBox layoutH = new HBox(10);
        layoutH.getChildren().addAll(checkBox1, checkBox2, checkBox3);
        VBox layoutV = new VBox(10);
        layoutV.getChildren().addAll(label, layoutH, button);
        Scene scene = new Scene(layoutV,300,200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
