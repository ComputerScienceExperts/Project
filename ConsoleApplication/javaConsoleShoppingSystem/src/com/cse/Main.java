package com.cse;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, String> userMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static Product bl = new Product();


    public static void main(String[] args) {
        // Add some users to the userMap
        userMap.put("CSE", "12345");
        userMap.put("Chandan", "1234");


        boolean status = false;
        while (!status) {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    buyProduct();
                    break;
                case 3:
                    cancelProduct();
                    break;
                case 4:
                    bl.displayAllProducts();
                    break;
                case 5:
                    logout();
                    break;
                case 6:
                    status = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("=================================");
        System.out.println("1. Log in");
        System.out.println("2. Buy product");
        System.out.println("3. Cancel product");
        System.out.println("4. Display all products");
        System.out.println("5. Sign out");
        System.out.println("6. Exit");
        System.out.println("==================================");
        System.out.print("Enter your choice: ");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter password: ");
        
        if (sc.hasNextInt()) {
            int password = sc.nextInt();
            
            // Convert the integer password to a String for comparison
            String passwordStr = String.valueOf(password);

            if (userMap.containsKey(username) && userMap.get(username).equals(passwordStr)) {
                System.out.println("Login successful");
            } else {
                System.out.println("Invalid username or password");
            }
        } else {
            System.out.println("Password should be a number.");
            sc.next(); // Clear the invalid input
        }
    }


        private static void buyProduct() {
            int loggedInUser=0;
            if (loggedInUser == 0) {
                System.out.print("Enter product name: ");
                String productName = sc.next();
                System.out.print("Enter product price: ");
                double productPrice = sc.nextDouble();
                bl.buyProduct(productName, productPrice);
            } else {
                System.out.println("You need to log in first");
            }
        }

        private static void cancelProduct() {
            int loggedInUser=0;
            if (loggedInUser == 0) {
                System.out.print("Enter product name: ");
                String productName = sc.next();
                bl.cancelProduct(productName);
            } else {
                System.out.println("You need to log in first");
            }
        }

        private static void logout() {
            System.out.println("Logged out");
        }
    }