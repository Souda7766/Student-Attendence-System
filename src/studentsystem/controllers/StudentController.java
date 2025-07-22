package studentsystem.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import studentsystem.models.Student;

public class StudentController {

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> rollColumn;

    @FXML
    private TableColumn<Student, String> classNameColumn;

    @FXML
    private TextField nameField;  // FXML এর TextField fx:id অনুযায়ী

    @FXML
    private TextField rollField;

    @FXML
    private TextField classField;

    private int nextId = 3; // Assuming you already have 2 students initially

    @FXML
    public void initialize() {
        // Set up the columns to use the properties from Student model
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        rollColumn.setCellValueFactory(new PropertyValueFactory<>("roll"));
        classNameColumn.setCellValueFactory(new PropertyValueFactory<>("className"));

        // Add sample data
        studentTable.getItems().addAll(
            new Student(1, "Souda", "101", "Six"),
            new Student(2, "Nishat", "102", "Six")
        );
    }

    @FXML
    private void handleAddStudent() {
        String name = nameField.getText();
        String roll = rollField.getText();
        String className = classField.getText();

        if (name.isEmpty() || roll.isEmpty() || className.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields.");
            alert.showAndWait();
            return;
        }

        Student newStudent = new Student(nextId++, name, roll, className);
        studentTable.getItems().add(newStudent);

        // Clear input fields
        nameField.clear();
        rollField.clear();
        classField.clear();
    }

    @FXML
    private void handleDeleteStudent() {
        Student selected = studentTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            studentTable.getItems().remove(selected);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a student to delete.");
            alert.showAndWait();
        }
    }
}
