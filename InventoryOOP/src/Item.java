import java.io.Serial;
import java.util.Scanner;
import java.io.Serializable;

public class Item implements Serializable, ItemInterface {
    @Serial
    private static final long serialVersionUID = 1L;

    private String itemName;
    private String itemDescription;
    private int itemQuantity;

    public Item(String itemName, String itemDescription, int itemQuantity) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public static Item addItem() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the item to add: ");
        String tempName = input.nextLine();
        System.out.print("Enter the description of the item to add: ");
        String tempDesc = input.nextLine();
        System.out.print("Enter the quantity of the item to add: ");
        String tempQuantity = input.nextLine();

        return new Item(tempName, tempDesc, Integer.parseInt(tempQuantity));
    }

    public String toCsvRow(String delimiter) {
        return "Item" + delimiter + this.itemName + delimiter + this.itemDescription + delimiter + this.itemQuantity;
    }

    public static Item fromCsvParts(String csvRow, String delimiter) {
        try {
            String[] parts = csvRow.split(delimiter);

            String name = parts[0];
            String desc = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            return new Item(name, desc, quantity);
        } catch (Exception e) {
            return null;
        }
    }
}