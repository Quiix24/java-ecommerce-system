package javaapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CartController implements Initializable {

    @FXML
    private Button homebtn_0;
    @FXML
    private Button checkout;
    @FXML
    private Button showcart;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void switchcheckout(ActionEvent event) throws IOException {
     ShoppingCart cart = ShoppingCart.getInstance();
        Double total = cart.getTotalPrice();
        System.out.println("------------------\nOrder has been placed \nyour Total Price is: "+total);
    }

    @FXML
        private void showItems(ActionEvent event) {
        // Retrieve items from the shopping cart and print them
        ShoppingCart cart = ShoppingCart.getInstance();
        List<String> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("------------------\nItems in the shopping cart:");
            for (String item : items) {
                System.out.println(item);
            }
        }
    }

    @FXML
    private void switchhome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        stage = (Stage) ((Parent) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    }
    

