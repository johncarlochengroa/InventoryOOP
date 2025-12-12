import ItemTypes.*;

import java.util.Random;
import java.util.Scanner;

public class ItemManager {
    Object addItem() {
        String name;
        int quantity;
        int itemType;
        int calories;
        char isCookedInput;
        char isPoisonousInput;
        Boolean isCooked = null;
        Boolean isPoisonous = null;
        int damage;
        int durability;

        System.out.print("Enter the name of the item you want to add: \n>> ");
        name = new Scanner(System.in).next();
        System.out.print("Enter the quantity of the item you want to add: \n>> ");
        quantity = new Scanner(System.in).nextInt();
        System.out.print("Enter the Item Type of the item:\n(1) - Food\n(2) - Tool\n(3) - Weapon\n>> ");
        itemType = new Scanner(System.in).nextInt();
        if (itemType == 1) {
            System.out.print("Enter the amount of calories of the food you want to add: \n>> ");
            calories = new Scanner(System.in).nextInt();
            System.out.print("Is your food cooked?\n ('T' OR 'F' ONLY) \n>> ");
            isCookedInput = new Scanner(System.in).next().charAt(0);
            System.out.print("Is your food poisonous?\n ('T' OR 'F' ONLY) \n>> ");
            isPoisonousInput = new Scanner(System.in).next().charAt(0);

            if (isCookedInput == 'T'){
                isCooked = true;
            }
            else if (isCookedInput == 'F'){
                isCooked = false;
            }
            if (isPoisonousInput == 'T'){
                isPoisonous = true;
            }
            else if (isPoisonousInput == 'F'){
                isPoisonous = false;
            }

            return new Food(name, quantity, calories, isCooked, isPoisonous);
        }
        else if (itemType == 2) {
            System.out.print("Enter the amount of durability of the tool you want to add: \n>> ");
            durability = new Scanner(System.in).nextInt();

            if (durability > 255){
                durability = 255;
            }

            return new Tool(name, quantity, durability);
        }
        else if (itemType == 3) {
            System.out.print("Enter the amount of durability of the weapon you want to add: \n>> ");
            durability = new Scanner(System.in).nextInt();
            System.out.print("Enter the amount of damage of the weapon you want to add: \n>> ");
            damage = new Scanner(System.in).nextInt();

            if (durability > 255){
                durability = 255;
            }
            if (damage > 255){
                damage = 255;
            }

            return new Weapon(name, quantity, durability, damage);
        }
        return null;
    }

    void displayItem(Object item) {
        if (item instanceof Food) {
            Food food = (Food) item;
            System.out.println("Name: " + food.getName());
            System.out.println("Quantity: " + food.getQuantity());
            System.out.println("Calories: " + food.getCalories());
            System.out.println("Is Cooked?: " + food.getCooked());
            System.out.println("Is Poisonous?: " + food.getPoisonous());
        }
        else if (item instanceof Tool) {
            Tool tool = (Tool) item;
            System.out.println("Name: " + tool.getName());
            System.out.println("Quantity: " + tool.getQuantity());
            System.out.println("Durability: " + tool.getDurability() + " / 255");
        }
        else if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            System.out.println("Name: " + weapon.getName());
            System.out.println("Quantity: " + weapon.getQuantity());
            System.out.println("Durability: " + weapon.getDurability() + " / 255");
            System.out.println("Damage: " + weapon.getDamage() + " / 255");
        }
    }

    public String getNameItem(Object item) {
        if (item instanceof Food) {
            Food food = (Food) item;
            return food.getName();
        }
        else if (item instanceof Tool) {
            Tool tool = (Tool) item;
            return tool.getName();
        }
        else if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            return weapon.getName();
        }
        return null;
    }

    public Object cookFood(Object item) {
        Food food = null;
        if (item instanceof Food) {
            food = (Food) item;
            food.setCooked(true);
        }
        return food;
    }

    public Object useTool(Object item) {
        Random rand = new Random();
        int useRandom = rand.nextInt(1, 10);

        if (item instanceof Tool) {
            Tool tool = (Tool) item;
            int newDurability = tool.getDurability() - useRandom;
            if (newDurability < 0) {
                newDurability = 0;
            }
            tool.setDurability(newDurability);
            return tool;
        }

        if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            int newDurability = weapon.getDurability() - useRandom;
            if (newDurability < 0) {
                newDurability = 0;
            }
            weapon.setDurability(newDurability);
            return weapon;
        }
        return item;
    }
}
