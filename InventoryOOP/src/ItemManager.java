import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ItemManager {

    static Scanner input = new Scanner(System.in);

    static String[] addItem(){
        String[] properties = new String[7];
        properties[0] = "0";

        System.out.println("\nInventoryOOP: Add New Item");
        System.out.print("Enter the name of the item to add: ");
        properties[1] = input.nextLine();
        System.out.print("Enter the description of the item to add: ");
        properties[2] = input.nextLine();
        System.out.print("Enter the quantity of the item to add: ");
        properties[3] = input.nextLine();

        if (properties[2].toUpperCase(Locale.ROOT).equals("FOOD")){
            properties[0] = "1";
            System.out.print("Enter the calories of the food item to add: ");
            properties[4] = input.nextLine();
            System.out.print("Is food item dangerous?\n[Y] - Yes | [N] - No\n>> ");
            String isDangerous = input.nextLine();
            if (isDangerous.toUpperCase(Locale.ROOT).equals("Y")) {
                properties[5] = "Yes";
            }
            else if (isDangerous.toUpperCase(Locale.ROOT).equals("N")) {
                properties[5] = "No";
            }
            else {
                properties[5] = "";
            }
            System.out.print("Is food item vegan?\n[Y] - Yes | [N] - No\n>> ");
            String isVegan = input.nextLine();
            if (isVegan.toUpperCase(Locale.ROOT).equals("Y")) {
                properties[6] = "Yes";
            }
            else if (isVegan.toUpperCase(Locale.ROOT).equals("N")) {
                properties[6] = "No";
            }
            else {
                properties[6] = "";
            }
        }

        return properties;
    }

    static void displayProperties(String[] itemProperties){
        if (itemProperties[1].isEmpty() && itemProperties[2].isEmpty() && itemProperties[3].isEmpty()){
            System.out.println("No Item Detected");
            itemProperties[0] = "";
        }
        else {
            if (itemProperties[1].isEmpty()) {
                System.out.println("Missing Required Field: Item Name");
                itemProperties[0] = "";
            }
            if (itemProperties[2].isEmpty()) {
                System.out.println("Missing Required Field: Item Description");
                itemProperties[0] = "";
            }
            if (itemProperties[3].isEmpty()) {
                System.out.println("Missing Required Field: Item Quantity");
                itemProperties[0] = "";
            }
        }
        if (itemProperties[0].equals("0")) {
            Item item = new Item(itemProperties[1],itemProperties[2],Integer.parseInt(itemProperties[3]));
            System.out.println();
            System.out.println("Name of Item: " + item.getItemName());
            System.out.println("Description of Item: " + item.getItemDescription());
            System.out.println("Quantity of Item: " + item.getItemQuantity());
        }
        else if (itemProperties[0].equals("1")) {
            Food food = new Food(itemProperties[1],itemProperties[2],Integer.parseInt(itemProperties[3]),itemProperties[4],itemProperties[5],itemProperties[6]);
            System.out.println();
            System.out.println("Name of Food: " + food.getItemName());
            System.out.println("Description of Food: " + food.getItemDescription());
            System.out.println("Quantity of Food: " + food.getItemQuantity());
            if(!Objects.equals(food.getCalories(), "")){
                System.out.println("Calories of Food: " + food.getCalories());
            }
            if(!Objects.equals(food.getIsDangerous(), "")){
                System.out.println("Is the Food Dangerous?: " + food.getIsDangerous());
            }
            if(!Objects.equals(food.getIsVegan(), "")){
                System.out.println("Is the Food Vegan?: " + food.getIsVegan());
            }
        }
    }

    static void displayMenu(boolean alreadyPopulated){
        if (alreadyPopulated) {
            System.out.print("\nInventory Action\n[1] - Identify Item\n[2] - Delete Item\n[3] - Exit\n>> ");
        }
        else {
            System.out.print("\nInventory Action\n[1] - Add Item\n[2] - Exit\n>> ");
        }
    }
}
