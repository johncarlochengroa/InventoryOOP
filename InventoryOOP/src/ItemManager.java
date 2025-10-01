import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ItemManager {

    static Scanner input = new Scanner(System.in);

    static void displayProperties(Object object){
        if (object instanceof Item item) {
            System.out.println();
            System.out.println("Name of Item: " + item.getItemName());
            System.out.println("Description of Item: " + item.getItemDescription());
            System.out.println("Quantity of Item: " + item.getItemQuantity());
        }
        else if (object instanceof Food food) {
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
