package javaapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

    @FXML
    private Button pizzaAdd;
    @FXML
    private Button seafoodAdd;
    @FXML
    private Button burgerAdd;
    @FXML
    private Button pastaAdd;
    @FXML
    private Button cart;
    @FXML
    private Button startTaskButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
        public void addItem(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        String item = "";
        Double price = 0.0;

        switch (sourceButton.getId()) {
            case "pizzaAdd":
                item = "Pizza";
                price = 40.0;
                break;
            case "seafoodAdd":
                item = "Seafood";
                price = 50.0;
                break;
            case "burgerAdd":
                item = "Burger";
                price = 30.0;
                break;
            case "pastaAdd":
                item = "Pasta";
                price = 20.0;                
                break;
        }
         ShoppingCart cart = ShoppingCart.getInstance(); // Obtain the instance of ShoppingCart
    cart.addItem(item,price); // Use the instance to add the item to the cart
    }

    @FXML
    private void shoppingcartscreen(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("cart.fxml"));
        stage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cart");
        stage.show();
    }

    @FXML
    private void startBackgroundTask(ActionEvent event) {
         // Create a new thread for the background task
    Thread backgroundThread = new Thread(() -> {
        for (int i = 1; i <= 10; i++) {
            final int count = i; // Make count effectively final
            // Update the UI using Platform.runLater to ensure it's done on the JavaFX Application Thread
            System.out.println(count); // Update the startTaskButton text
            try {
                // Sleep for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    Thread backgroundThread2 = new Thread(() -> {
        for (int i = 10; i > 0; i--) {
            final int count = i; // Make count effectively final
            // Update the UI using Platform.runLater to ensure it's done on the JavaFX Application Thread
            System.out.println(count); // Update the startTaskButton text
            try {
                // Sleep for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    // Start the background thread
    backgroundThread.start();
    backgroundThread2.start();
    
    }
    
}
