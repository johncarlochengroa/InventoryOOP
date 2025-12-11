package ItemTypes;

public class Food extends Item {
    private int calories;
    private Boolean isCooked;
    private Boolean isPoisonous;

    public Food(String name, int quantity, int calories, Boolean isCooked, Boolean isPoisonous) {
        super(name, quantity);
        this.calories = calories;
        this.isCooked = isCooked;
        this.isPoisonous = isPoisonous;
    }

    public int getCalories() {
        return calories;
    }
    public Boolean getCooked() {
        return isCooked;
    }
    public Boolean getPoisonous() {
        return isPoisonous;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void setCooked(Boolean cooked) {
        isCooked = cooked;
    }
    public void setPoisonous(Boolean poisonous) {
        isPoisonous = poisonous;
    }
}
