package com.inventory;
import java.util.Scanner;
public class InventorySystem {
    public static void main(String[] args) {
        Inventory<Item> inventory = new Inventory<>();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nInventory System");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter item quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter item price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    Item newItem = new Item(name, quantity, price);
                    inventory.addItem(newItem);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemNameToRemove = sc.nextLine();
                    Item itemToRemove = null;
                    for (Item item : inventory.getItems()) {
                        if (item.getName().equalsIgnoreCase(itemNameToRemove)) {
                            itemToRemove = item;
                            break;
                        }
                    }
                    if (itemToRemove != null) {
                        inventory.removeItem(itemToRemove);
                    } else {
                        System.out.println("Item not found in inventory.");
                    }
                    break;

                case 3:
                    inventory.viewItems();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting Inventory System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}