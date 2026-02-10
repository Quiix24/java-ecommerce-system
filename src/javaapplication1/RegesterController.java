package javaapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegesterController implements Initializable {

    @FXML
    private TextField usrname;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Button Regester;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void homepage(ActionEvent event) {
        // Validate passwords match
        String pass = password.getText();
        String confirmPass = confirmPassword.getText();
        if (!pass.equals(confirmPass)) {
            showAlert("Password and Confirm Password do not match");
            return;
        }

        // Insert user data into database
        String username = usrname.getText();
        String userEmail = email.getText();

        try {
            DatabaseConnection.insertUser(username, userEmail, pass);
            showAlert("User registered successfully!");

            // Redirect to homepage
            Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (SQLException e) {
            showAlert("Error occurred while registering user: " + e.getMessage());
        } catch (IOException ex) {
            showAlert("Error occurred while loading homepage: " + ex.getMessage());
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
