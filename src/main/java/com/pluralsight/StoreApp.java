package com.pluralsight;

import java.util.ArrayList;

public class StoreApp {
    public static void main(String[] args) {

    }

    public static ArrayList<Product> getInvenotry(){
        ArrayList<Product> inventory = new ArrayList<Product>();

        inventory.add(new Product(1, "football" , 50.00));
        inventory.add(new Product(2, "basketball" , 30.00));
        inventory.add(new Product(3, "baseball" , 10.00));
        inventory.add(new Product(4, "hockey puck" , 20.00));
        inventory.add(new Product(5, "soccer ball" , 30.00));

        return inventory;

    }
}
