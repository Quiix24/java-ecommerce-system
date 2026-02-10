package javaapplication1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignLogScreen extends Application  {

    public static void main(String[] args) {
        launch();
    }
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("SignLogSceen.fxml"));
       Scene sece = new Scene(root);
       stage.setScene(sece);
       stage.setTitle("Login");
       stage.show();    }
        
        
    }
    

