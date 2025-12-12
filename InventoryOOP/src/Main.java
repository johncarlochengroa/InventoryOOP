/**
 * InventoryOOP
 * A Project that demonstrates a basic OOP approach.
 *
 * Project by John Carlo E. Cheng Roa
 * Version 8 Milestone 3
 * December 12, 2025 - 7:34 PM
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

        while (true) {
            System.out.println("\nInventoryOOP\n");
            dm.printInventory(slotIndex);
            dm.printOptions(-1,null);
            slotIndex = input.nextInt();

            if (slotIndex == 5) {
                break;
            }

            while (true) {
                dm.printInventory(slotIndex);
                if (itemList[slotIndex - 1] == null) {
                    dm.printOptions(0,null);
                    slotActionIndex = input.nextInt();
                    if (slotActionIndex == 2) {
                        slotIndex = 0;
                        break;
                    }
                    else if (slotActionIndex == 1) {
                        itemList[slotIndex - 1] = im.addItem();
                    }
                }
                else if (itemList[slotIndex - 1] instanceof Food) {
                    dm.printOptions(1,im.getNameItem(itemList[slotIndex - 1]));
                    slotActionIndex = input.nextInt();
                    if (slotActionIndex == 5) {
                        slotIndex = 0;
                        break;
                    }
                    switch (slotActionIndex) {
                        case 1:
                            itemList[slotIndex - 1] = null;
                            itemList[slotIndex - 1] = im.addItem();
                            break;
                        case 2:
                            im.displayItem(itemList[slotIndex - 1]);
                            break;
                        case 3:
                            im.cookFood(itemList[slotIndex - 1]);
                            break;
                        case 4:
                            itemList[slotIndex - 1] = null;
                            break;
                        default:
                            break;
                    }
                }
                else if (itemList[slotIndex - 1] instanceof Tool) {
                    dm.printOptions(2,im.getNameItem(itemList[slotIndex - 1]));
                    slotActionIndex = input.nextInt();
                    if (slotActionIndex == 4) {
                        slotIndex = 0;
                        break;
                    }
                    switch (slotActionIndex) {
                        case 1:
                            itemList[slotIndex - 1] = null;
                            itemList[slotIndex - 1] = im.addItem();
                            break;
                        case 2:
                            im.displayItem(itemList[slotIndex - 1]);
                            break;
                        case 3:
                            im.useTool(itemList[slotIndex - 1]);
                            break;
                        default:
                            break;
                    }
                }
                else if (itemList[slotIndex - 1] instanceof Weapon) {
                    dm.printOptions(3,im.getNameItem(itemList[slotIndex - 1]));
                    slotActionIndex = input.nextInt();
                    if (slotActionIndex == 4) {
                        slotIndex = 0;
                        break;
                    }
                    switch (slotActionIndex) {
                        case 1:
                            itemList[slotIndex - 1] = null;
                            itemList[slotIndex - 1] = im.addItem();
                            break;
                        case 2:
                            im.displayItem(itemList[slotIndex - 1]);
                            break;
                        case 3:
                            im.useTool(itemList[slotIndex - 1]);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}