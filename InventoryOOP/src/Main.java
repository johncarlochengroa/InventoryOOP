/**
 * InventoryOOP
 * A Project that demonstrates a basic OOP approach.
 *
 * Project by John Carlo E. Cheng Roa
 * Version 8 Milestone 2
 * December 12, 2025 - 2:02 PM
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
                if (itemList[slotIndex - 1] == null) {
                    System.out.print("(1) - Add Item\n(2) - Return\n>> ");
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
                    System.out.println(">> " + im.getNameItem(itemList[slotIndex - 1]) + " <<");
                    System.out.print("(1) - Replace Item\n(2) - Display Item\n(3) - Cook Food\n(4) - Eat Food\n(5) - Return\n>> ");
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
                    System.out.println(">> " + im.getNameItem(itemList[slotIndex - 1]) + " <<");
                    System.out.print("(1) - Add Item\n(2) - Display Item\n(3) - Use Tool\n(4) - Return\n>> ");
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
                    System.out.println(">> " + im.getNameItem(itemList[slotIndex - 1]) + " <<");
                    System.out.print("(1) - Add Item\n(2) - Display Item\n(3) - Use Tool\n(4) - Return\n>> ");
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