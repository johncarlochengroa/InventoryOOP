package ItemTypes;

public class Tool extends Item {
    private int durability;

    public Tool(String name, int quantity, int durability) {
        super(name, quantity);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
