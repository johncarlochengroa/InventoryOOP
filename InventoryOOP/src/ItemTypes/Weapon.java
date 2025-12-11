package ItemTypes;

public class Weapon extends Item {
    private int durability;
    private int damage;

    public Weapon(String name, int quantity, int durability, int damage) {
        super(name, quantity);
        this.durability = durability;
        this.damage = damage;
    }

    public int getDurability() {
        return durability;
    }
    public int getDamage() {
        return damage;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
