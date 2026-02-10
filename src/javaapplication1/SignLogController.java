package javaapplication1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignLogController implements Initializable {

    @FXML
    private Button creatAccountbtn;

    @FXML
    private TextField userId;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code here
    }

    @FXML
    private void switchToRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("regester.fxml"));
        stage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void checkUser(ActionEvent event) throws IOException, SQLException {
         String username = userId.getText();
    String password = this.password.getText();

    try {
        if (DatabaseConnection.checkUserCredentials(username, password)) {
            // Authentication successful, redirect to home page
            Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            stage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Home Page");
            stage.show();
        } else {
            // Authentication failed, display error message
            System.out.println("Invalid credentials");
        }
    } 
    catch (SQLException e) {
        // Handle database error
        e.printStackTrace();
        System.out.println("Database error: " + e.getMessage());
    }
    }
}

