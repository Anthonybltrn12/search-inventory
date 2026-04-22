package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StoreApp {
    public static void main(String[] args) {
        //creating inveotry arraylist
        ArrayList<Product> inventoryList = getInventory();

        System.out.println("----Inventory List----");
        //looping through array
        for(int i = 0; i < inventoryList.size(); i++){
            Product product = inventoryList.get(i);
            System.out.printf("%s %s cost $%.2f \n", product.getId(), product.getName(), product.getPrice());
        }
    }
        //method to create values for the array
    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<Product>();

        inventory.add(new Product(1, "football" , 50));
        inventory.add(new Product(2, "basketball" , 30));
        inventory.add(new Product(3, "baseball" , 10));
        inventory.add(new Product(4, "hockey puck" , 20));
        inventory.add(new Product(5, "soccer ball" , 30));

        return inventory;

    }
}
