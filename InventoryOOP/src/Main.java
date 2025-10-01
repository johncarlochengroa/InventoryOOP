/**
 * InventoryOOP
 * A Project that demonstrates a basic OOP approach.
 *
 * Project by John Carlo E. Cheng Roa
 * Version 7
 * October 2, 2025 - 12:37 AM
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Object item = null;
        boolean alreadyPopulated;

        System.out.println("\nInventoryOOP");

        while (true) {
            alreadyPopulated = SaveManager.fileExists();

            if (alreadyPopulated && item == null) {
                item = SaveManager.loadFile();
            }

            ItemManager.displayMenu(alreadyPopulated);
            String userChoice = input.nextLine();
            if (alreadyPopulated) {
                switch (userChoice) {
                    case "1":
                        ItemManager.displayProperties(item);
                        break;
                    case "2":
                        SaveManager.deleteFile();
                        break;
                    case "3":
                        SaveManager.saveItem(item);
                        input.close();
                        return;
                    default:
                        break;
                }
            }
            else {
                switch (userChoice) {
                    case "1":
                        System.out.print("\nSelect Item Type: \n[1] - Item\n[2] - Food\n>> ");
                        String itemType = input.nextLine();
                        item = switch (itemType) {
                            case "1" -> Item.addItem();
                            case "2" -> Food.addItem();
                            default -> item;
                        };
                        SaveManager.saveItem(item);
                        break;
                    case "2":
                        input.close();
                        return;
                    default:
                        break;
                }
            }
        }
    }
}