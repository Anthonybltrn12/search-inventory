package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static Scanner theScanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("---Welcome to our store!---");
        menu();

    }

    public static void menu() throws IOException {
        //create menu for user
        System.out.println("""
                What do you want to do?
                1- List all products
                2- Lookup a product by its id
                3- Find all products within a price range
                4- Add a new product
                5- Quit the application
                Enter command:
                """);
        int userCommand = theScanner.nextInt();
        boolean isRunning = true;
        while(isRunning = true;) {
            //different inputs for users
            switch (userCommand) {
                case 1:
                    displayInventory();
                    isRunning = false; //trying to get app to return to menu after display method finishes
                    break;
                case 2:
                    searchById();
                    break;
                case 3:
                    priceRange();

            }
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

    public static void displayInventory() throws IOException {
        ArrayList<Product> inventoryList = getInventory();

        System.out.println("----Inventory List----");
        //looping through array
        for(int i = 0; i < inventoryList.size(); i++){

            Product product = inventoryList.get(i);
            System.out.printf("%s %s cost $%.2f \n", product.getId(), product.getName(), product.getPrice());
        }


    }
    public static void searchById() throws IOException {
        ArrayList<Product> list = getInventory();
        //DISPLAY THE PRODUCTS AND THEIR IDS FOR USER

        System.out.println("Enter the Products ID here: ");
        int prodId = theScanner.nextInt();
        for(Product p : list){
            if(p.getId() == prodId){
                System.out.println(p.getId() + " " + p.getName());
            }
        }

    }

    public static void priceRange() throws IOException {
        ArrayList<Product> inventoryList = getInventory();
        // asking for a price range from user
        System.out.println("""
                What price range are you looking for? 
                1: Under $10
                2: Under $30
                3: Under $60
                4: Over $60 
                """);
        int userPR = theScanner.nextInt();
        //looping through the products
        for(int i = 0; i < inventoryList.size(); i++){
            Product product = inventoryList.get(i);
            switch(userPR){    //storing correct products for price range depending on the users response
                case 1:
                    if(product.getPrice() <= 10) {
                        System.out.println(product.getName() + " " + product.getPrice());
                    }
                    break;
                case 2:
                    if(product.getPrice() > 10 && product.getPrice() <= 30){
                        System.out.println(product.getName() + " " + product.getPrice());
                    }
                    break;
                case 3:
                    if(product.getPrice() > 30 && product.getPrice() <= 60){
                        System.out.println(product.getName() + " " + product.getPrice());
                    }
                    break;
                case 4:
                    if(product.getPrice() > 60){
                        System.out.println(product.getName() + " " + product.getPrice());
                    }
                    break;
            }

        }


    }
}
