package sample.Main21;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, String> studentIDColumn;

    @FXML
    private TableColumn<Student, String> studentNameColumn;

    @FXML
    private TableColumn<Student, String> studentEmailColumn;

    @FXML
    private TableColumn<Student, Integer> studentAgeColumn;


    private ObservableList<Student> studentList;

    @FXML
    private TextField idTextInput;

    @FXML
    private TextField nameTextInput;

    @FXML
    private TextField emailTextInput;

    @FXML
    private TextField ageTextInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        studentList = FXCollections.observableArrayList(
                new Student("1", "huy", "huy8895@gmail.com", 25),
                new Student("2", "hoang", "hoang3799@gmail.com", 25)
        );

        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        studentTableView.setItems(studentList);

    }

    public void addStudent(ActionEvent actionEvent){
        Student newStudent = new Student();
        newStudent.setId(idTextInput.getText());
        newStudent.setName(nameTextInput.getText());
        newStudent.setEmail(emailTextInput.getText());
        newStudent.setAge(Integer.parseInt(ageTextInput.getText()));

        studentList.add(newStudent);
    }

    public void deleteStudent(ActionEvent event){
        if (studentTableView.getSelectionModel().getSelectedItem() != null){

            Student selected = studentTableView.getSelectionModel().getSelectedItem();
            System.out.println(selected.getName() + " deleted");
            studentList.remove(selected);
        }
    }

    public void showStudentDetail(ActionEvent event) throws IOException {
        if (studentTableView.getSelectionModel().getSelectedItem() != null){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StudentDetail.fxml"));
            Parent studentDetailRoot = loader.load();

            Scene scene = new Scene(studentDetailRoot);

            StudentDetailController controller = loader.getController();
            controller.setStudentDetail(studentTableView.getSelectionModel().getSelectedItem());

            stage.setTitle("Student Detail");
            stage.setScene(scene);
        }

    }

}
