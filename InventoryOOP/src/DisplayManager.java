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
}
