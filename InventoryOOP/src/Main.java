/**
 * InventoryOOP
 * A Project that demonstrates a basic OOP approach.
 *
 * Project by John Carlo E. Cheng Roa
 * Version 7 Patch 1
 * October 2, 2025 - 11:16 AM
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Object> items = new ArrayList<>();
        Object currentItem = null;
        boolean alreadyPopulated;

        System.out.println("\nInventoryOOP");

        while (true) {
            alreadyPopulated = SaveManager.fileExists();

            if (alreadyPopulated && items.isEmpty()) {
                items = SaveManager.loadFile();
                if(!items.isEmpty()) {
                    currentItem = items.getFirst();
                }
            }

            ItemManager.displayMenu(alreadyPopulated);
            String userChoice = input.nextLine();
            if (alreadyPopulated) {
                switch (userChoice) {
                    case "1":
                        if (currentItem == null) {
                            System.out.println("No item available to identify.");
                        } else {
                            ItemManager.displayProperties(currentItem);
                        }
                        break;
                    case "2":
                        SaveManager.deleteFile();
                        break;
                    case "3":
                        if (currentItem != null) {
                            SaveManager.saveItem(currentItem);
                        }
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
                        currentItem = switch (itemType) {
                            case "1" -> Item.addItem();
                            case "2" -> Food.addItem();
                            default -> currentItem;
                        };
                        if (currentItem != null) {
                            SaveManager.saveItem(currentItem);
                        }
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