package javaapplication1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private static ShoppingCart instance;
    private List<String> items;
    private Map<String, Double> itemPrices;

    private ShoppingCart() {
        items = new ArrayList<>();
        itemPrices = new HashMap<>();
    }

    public static synchronized ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(String item, double price) {
        items.add(item);
        itemPrices.put(item, price);
        System.out.println(item+" has been added for "+price+"$");
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public double getPrice(String item) {
        return itemPrices.getOrDefault(item, 0.0);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(this::getPrice).sum();
    }

    public void printItemsAndTotalPrice() {
        System.out.println("Items in the shopping cart:");
        for (String item : items) {
            System.out.println(item + ": $" + getPrice(item));
        }
        System.out.println("Total Price: $" + getTotalPrice());
    }
}
