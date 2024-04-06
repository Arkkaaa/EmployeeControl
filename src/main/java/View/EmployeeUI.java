package View;

import DAO.EmployeeDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class EmployeeUI extends Application {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ChoiceBox<String> languageSelect;
    private Label languageLabel;
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label emailLabel;
    private TextField firstNameTextField;
    private TextField lastNameTextField;
    private TextField emailTextField;
    private Button submitButton;
    private ResourceBundle resourceBundle;


    public void updateLanguage(Stage primaryStage) {
        languageLabel.setText(resourceBundle.getString("label_lang"));
        firstNameLabel.setText(resourceBundle.getString("label_FN"));
        lastNameLabel.setText(resourceBundle.getString("label_LN"));
        emailLabel.setText(resourceBundle.getString("label_Email"));
        submitButton.setText(resourceBundle.getString("button_submit"));
        primaryStage.setTitle(resourceBundle.getString("title"));
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        resourceBundle = ResourceBundle.getBundle("Lang", new Locale("en", "US"));
        primaryStage.setTitle(resourceBundle.getString("title"));
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Scene scene = new Scene(gridPane, 300, 275);
        languageLabel = new Label(resourceBundle.getString("label_lang"));
        languageSelect = new ChoiceBox<>();

        languageSelect.getItems().addAll("English", "فارسی", "日本語");
        languageSelect.setValue("English");
        languageSelect.setOnAction(e -> {
            switch (languageSelect.getValue()) {
                case "English":
                    resourceBundle = ResourceBundle.getBundle("Lang", new Locale("en", "US"));
                    break;
                case "فارسی":
                    resourceBundle = ResourceBundle.getBundle("Lang_fa_IR", new Locale("fa", "IR"));
                    break;
                case "日本語":
                    resourceBundle = ResourceBundle.getBundle("Lang_ja_JP", new Locale("ja", "JP"));
                    break;
            }
            updateLanguage(primaryStage);

        });

        gridPane.add(languageLabel, 0, 0);
        gridPane.add(languageSelect, 1, 0);
        firstNameLabel = new Label(resourceBundle.getString("label_FN"));
        lastNameLabel = new Label(resourceBundle.getString("label_LN"));
        emailLabel = new Label(resourceBundle.getString("label_Email"));
        firstNameTextField = new TextField();
        lastNameTextField = new TextField();
        emailTextField = new TextField();
        submitButton = new Button(resourceBundle.getString("button_submit"));
        submitButton.setOnAction(e -> {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String email = emailTextField.getText();

            String tableName;
            switch (languageSelect.getValue()) {
                case "English":
                    tableName = "employee_en";
                    break;
                case "فارسی":
                    tableName = "employee_fa";
                    break;
                case "日本語":
                    tableName = "employee_ja";
                    break;
                default:
                    tableName = "employee_en";
                    break;
            }


            employeeDAO.insertEmployee(firstName, lastName, email, tableName);
            firstNameTextField.clear();
            lastNameTextField.clear();
            emailTextField.clear();
        });

        gridPane.add(firstNameLabel, 0, 1);
        gridPane.add(firstNameTextField, 1, 1);
        gridPane.add(lastNameLabel, 0, 2);
        gridPane.add(lastNameTextField, 1, 2);
        gridPane.add(emailLabel, 0, 3);
        gridPane.add(emailTextField, 1, 3);
        gridPane.add(submitButton, 1, 4);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
