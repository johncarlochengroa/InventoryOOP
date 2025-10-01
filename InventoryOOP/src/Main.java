/**
 * InventoryOOP
 * A Project that demonstrates a basic OOP approach.
 *
 * Project by John Carlo E. Cheng Roa
 * Version 5 Patch 2
 * October 1, 2025 - 3:14 PM
 */

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] item = SaveManager.loadFile();
        boolean alreadyPopulated = item != null && item.length > 0 && Objects.equals(item[0], "");

        System.out.println("\nInventoryOOP");

        while (true) {
            ItemManager.displayMenu(alreadyPopulated);
            String userChoice = input.nextLine().trim();
            if (alreadyPopulated) {
                switch (userChoice) {
                    case "1":
                        if(item[0] != null) {
                            ItemManager.displayProperties(item);
                        }
                        else{
                            alreadyPopulated = false;
                        }
                        break;
                    case "2":
                        SaveManager.deleteFile();
                        alreadyPopulated = false;
                        break;
                    case "3":
                        SaveManager.saveFile(item);
                        return;
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
                        input.close();
                        return;
                    default:
                        break;
                }
            }
        }
    }
}