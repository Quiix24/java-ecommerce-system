package javaapplication1;

import java.util.List;

public interface ShoppingCartInterface {
    void addItem(String item, double price);
    List<String> getItems();
    double getPrice(String item);
    double getTotalPrice();
    void printItemsAndTotalPrice();
}
