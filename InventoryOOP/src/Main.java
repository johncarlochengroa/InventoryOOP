/**
 * InventoryOOP
 * Project by John Carlo E. Cheng Roa
 *
 * A Project that demonstrates a basic OOP approach.
 * Version 2
 * September 17, 2025 - 5:52 AM
 */

import java.util.Scanner;

public class Main {

    static String[] questions(){
        Scanner input = new Scanner(System.in);

        String[] properties = new String[3];
        System.out.print("Enter the name of the item you want to add: ");
        properties[0] = input.nextLine();
        System.out.print("Enter the description of the item you want to add: ");
        properties[1] = input.nextLine();
        System.out.print("Enter the quantity of the item you want to add: ");
        properties[2] = input.nextLine();

        return properties;
    }

    public static void main(String[] args) {
        String[] itemProperties = questions();

        Item item = new Item(itemProperties[0],itemProperties[1],Integer.parseInt(itemProperties[2]));

        System.out.println();
        System.out.println("Name of Item: " + item.getItemName());
        System.out.println("Description of Item: " + item.getItemDescription());
        System.out.println("Quantity of Item: " + item.getItemQuantity());
    }
}