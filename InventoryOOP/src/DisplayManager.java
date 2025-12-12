public class DisplayManager {
    void printInventory(int slot) {
        System.out.println("┏━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┓");
        System.out.println("┃  (1)  ┃  (2)  ┃  (3)  ┃  (4)  ┃  (5)  ┃");
        switch(slot) {
            case 0:
                System.out.println("┗━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┛");
                break;
            case 1:
                System.out.println("┗━━━┻━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┛");
                break;
            case 2:
                System.out.println("┗━━━━━━━┻━━━┻━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┛");
                break;
            case 3:
                System.out.println("┗━━━━━━━┻━━━━━━━┻━━━┻━━━┻━━━━━━━┻━━━━━━━┛");
                break;
            case 4:
                System.out.println("┗━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━┻━━━┻━━━━━━━┛");
                break;
            case 5:
                System.out.println("┗━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━┻━━━┛");
                break;
        }
    }

    void printOptions(int itemType, String itemName) {
        if (itemType == -1) {
            System.out.println("┃ (1-4) - Access Item Slot");
            System.out.println("┃  (5)  - Exit");
        }
        if (itemType > 0) {
            System.out.println("┃ " + itemName);
        }
        switch(itemType) {
            case 0:
                System.out.println("┃ (1) - Add Item");
                System.out.println("┃ (2) - Return");
                break;
            case 1:
                System.out.println("┃ (1) - Replace Item");
                System.out.println("┃ (2) - Display Food");
                System.out.println("┃ (3) - Cook Food");
                System.out.println("┃ (4) - Eat Food");
                System.out.println("┃ (5) - Return");
                break;
            case 2:
                System.out.println("┃ (1) - Replace Item");
                System.out.println("┃ (2) - Display Tool");
                System.out.println("┃ (3) - Use Tool");
                System.out.println("┃ (4) - Return");
                break;
            case 3:
                System.out.println("┃ (1) - Replace Item");
                System.out.println("┃ (2) - Display Weapon");
                System.out.println("┃ (3) - Use Weapon");
                System.out.println("┃ (4) - Return");
                break;
            default:
                break;
        }
        System.out.print(">> ");
    }
}
