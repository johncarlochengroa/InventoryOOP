/**
 * InventoryOOP
 * Project by John Carlo E. Cheng Roa
 *
 * A Project that demonstrates a basic OOP approach.
 * Version 1
 * September 17, 2025 - 5:42 AM
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the item you want to add: ");
        String itemName = input.nextLine();
        System.out.print("Enter the description of the item you want to add: ");
        String itemDescription = input.nextLine();
        System.out.print("Enter the quantity of the item you want to add: ");
        String itemPrice = input.nextLine();

        Item item = new Item(itemName,itemDescription,Integer.parseInt(itemPrice));

        System.out.println();
        System.out.println("Name of Item: " + item.getItemName());
        System.out.println("Description of Item: " + item.getItemDescription());
        System.out.println("Quantity of Item: " + item.getItemQuantity());
    }
}