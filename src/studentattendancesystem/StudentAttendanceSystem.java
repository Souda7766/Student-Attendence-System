package studentattendancesystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class StudentAttendanceSystem extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlLocation = getClass().getResource("/fxml/Login.fxml");
        System.out.println("FXML URL: " + fxmlLocation);

        if (fxmlLocation == null) {
            System.err.println("FXML file not found!");
            System.exit(1);
        }

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Student Attendance System - Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
