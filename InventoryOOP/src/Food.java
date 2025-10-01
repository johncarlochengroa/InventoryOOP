import java.io.Serial;
import java.util.Locale;
import java.util.Scanner;
import java.io.Serializable;

public class Food extends Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String calories;
    private String isDangerous;
    private String isVegan;

    public Food(String itemName, String itemDescription, int itemQuantity,
                String calories, String isDangerous, String isVegan) {
        super(itemName, itemDescription, itemQuantity);
        this.calories = calories;
        this.isDangerous = isDangerous;
        this.isVegan = isVegan;
    }

    public String getCalories() {
        return calories;
    }
    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getIsDangerous() {
        return isDangerous;
    }
    public void setIsDangerous(String dangerous) {
        isDangerous = dangerous;
    }

    public String getIsVegan() {
        return isVegan;
    }
    public void setIsVegan(String vegan) {
        isVegan = vegan;
    }

    public static Food addItem() {
        Scanner foodInput = new Scanner(System.in);

        System.out.println("\nInventoryOOP: Add New Item");
        System.out.print("Enter the name of the item to add: ");
        String tempName = foodInput.nextLine();
        System.out.print("Enter the description of the item to add: ");
        String tempDesc = foodInput.nextLine();
        System.out.print("Enter the quantity of the item to add: ");
        String tempQuantity = foodInput.nextLine();
        System.out.print("Enter the calories of the food item to add: ");
        String tempCal = foodInput.nextLine();
        System.out.print("Is food item dangerous?\n[Y] - Yes | [N] - No\n>> ");
        String tempDanger = foodInput.nextLine();
        if (tempDanger.toUpperCase(Locale.ROOT).equals("Y")) {
            tempDanger = "Yes";
        }
        else if (tempDanger.toUpperCase(Locale.ROOT).equals("N")) {
            tempDanger = "No";
        }
        else {
            tempDanger = "";
        }
        System.out.print("Is food item vegan?\n[Y] - Yes | [N] - No\n>> ");
        String tempVegan = foodInput.nextLine();
        if (tempVegan.toUpperCase(Locale.ROOT).equals("Y")) {
            tempVegan = "Yes";
        }
        else if (tempVegan.toUpperCase(Locale.ROOT).equals("N")) {
            tempVegan = "No";
        }
        else {
            tempVegan = "";
        }

        return new Food(tempName, tempDesc, Integer.parseInt(tempQuantity), tempCal, tempDanger, tempVegan);
    }
}
