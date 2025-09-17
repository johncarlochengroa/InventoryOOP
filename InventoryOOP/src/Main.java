/**
 * InventoryOOP
 * A Project that demonstrates a basic OOP approach.
 *
 * Project by John Carlo E. Cheng Roa
 * Version 5
 * September 17, 2025 - 6:06 PM
 */

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] item;
        boolean alreadyPopulated = false;

        item = SaveManager.loadFile();
        if (!Objects.equals(item[0], "")) {
            alreadyPopulated = true;
        }

        System.out.println("\nInventoryOOP");

        label:
        while (true) {
            ItemManager.displayMenu(alreadyPopulated);
            String userChoice = input.nextLine();
            if (alreadyPopulated) {
                switch (userChoice) {
                    case "1":
                        ItemManager.printResults(item);
                        break;
                    case "2":
                        for (int i = 0; i < 7; i++) {
                            item[i] = "";
                        }
                        alreadyPopulated = false;
                        System.out.println("Item deleted successfully");
                        SaveManager.saveFile(item);
                        break;
                    case "3":
                        SaveManager.saveFile(item);
                        break label;
                    default:
                        break;
                }
            }
            else {
                switch (userChoice) {
                    case "1":
                        item = ItemManager.addItem();
                        alreadyPopulated = true;
                        break;
                    case "2":
                        break label;
                    default:
                        break;
                }
            }
        }
    }
}