package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StoreApp {
    public static void main(String[] args) throws IOException {
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
    public static ArrayList<Product> getInventory() throws IOException {
        try {
            //reader for csv file
            ArrayList<Product> inventory = new ArrayList<Product>();
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);

            String productLine;
            while ((productLine = buffReader.readLine()) != null) {
                String[] productArray = productLine.split("\\|");
                inventory.add(new Product(Integer.parseInt(productArray[0]), productArray[1], Double.parseDouble(productArray[2])));
            }

            return inventory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
