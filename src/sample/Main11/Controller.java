package sample.Main11;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TreeView<String> treeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TreeItem<String> root = new TreeItem<>();
        TreeItem<String> javaFx = new TreeItem<>("javaFx");
        TreeItem<String> sample = new TreeItem<>("sample");
        TreeItem<String> Main8 = new TreeItem<>("Main8");
        TreeItem<String> Main9 = new TreeItem<>("Main9");
        TreeItem<String> Main10 = new TreeItem<>("Main10");

        sample.getChildren().addAll(Main8, Main9, Main10);
        javaFx.getChildren().add(sample);

        root.getChildren().add(javaFx);

        root.setExpanded(true);
        sample.setExpanded(true);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue.getValue());

        });

    }
}
