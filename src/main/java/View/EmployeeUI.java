package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Objects;

public class EmployeeUI extends Application {

    ChoiceBox<String> SelectLang;
    private TextField Input_FN;
    private TextField Input_LN;
    private TextField Input_Email;
    private Label Label_FN;
    private Label Label_LN;
    private Label Label_Email;
    private Button Button_Submit;

    public void init() {

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/EmployeeScene.fxml"));

        // Create the scene
        Scene scene = new Scene(root);

        // Set the scene on the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Registration Form");
        primaryStage.show();
    }
}
