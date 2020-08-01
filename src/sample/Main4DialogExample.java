package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.w3c.dom.NodeList;

import java.util.Optional;

public class Main4DialogExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("login dialog");
        dialog.setHeaderText("signup");

        ButtonType loginButtonType = new ButtonType("login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField userName = new TextField();
        userName.setPromptText("userName");
        PasswordField password = new PasswordField();
        password.setPromptText("password");

        gridPane.add(new Label("UserName"), 0, 0);
        gridPane.add(userName, 1, 0);
        gridPane.add(new Label("Password"), 0, 1);
        gridPane.add(password, 1, 1);

        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);

        loginButton.setDisable(true);

        userName.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());

        });

        dialog.getDialogPane().setContent(gridPane);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(userName.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(userNamePassWord -> {
            System.out.println("Username= " + userNamePassWord.getKey() + " , Password= " + userNamePassWord.getValue());
        });


    }
}
