/**
 * InventoryOOP
 * A Project that demonstrates a basic OOP approach.
 *
 * Project by John Carlo E. Cheng Roa
 * Version 8 Milestone 1
 * December 12, 2025 - 2:34 AM
 */

import java.util.Scanner;

import ItemTypes.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ItemManager im = new ItemManager();
        DisplayManager dm = new DisplayManager();

        int slotIndex = 0;
        int slotActionIndex = 0;
        Object[] itemList = new Object[3];

        System.out.println("\nInventoryOOP\n");

        while (true) {
            dm.printInventory(slotIndex);
            System.out.print("(1-4) - Access Item Slot\n(5) - Exit\n>> ");
            slotIndex = input.nextInt();

            if (slotIndex == 5) {
                break;
            }

            while (true) {
                dm.printInventory(slotIndex);
                System.out.print("(1) - Add Item\n(2) - Display Item\n(3) - Return\n>> ");
                slotActionIndex = input.nextInt();

                if (slotActionIndex == 3) {
                    slotIndex = 0;
                    break;
                }

                switch (slotActionIndex) {
                    case 1:
                        itemList[slotIndex - 1] = im.addItem();
                        break;
                    case 2:
                        im.displayItem(itemList[slotIndex - 1]);
                }
            }
        }
    }
}