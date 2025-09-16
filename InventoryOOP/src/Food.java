public class Food extends Item {
    private String calories;
    private String isDangerous;
    private String isVegan;

    public Food(String itemName, String itemDescription, int itemQuantity,
                String calories, String isDangerous, String isVegan) {
        super(itemName, itemDescription, itemQuantity);
        this.calories = calories;
        this.isDangerous = isDangerous;
        this.isVegan = isVegan;
    }

    public String getCalories() {
        return calories;
    }
    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getIsDangerous() {
        return isDangerous;
    }
    public void setIsDangerous(String dangerous) {
        isDangerous = dangerous;
    }

    public String getIsVegan() {
        return isVegan;
    }
    public void setIsVegan(String vegan) {
        isVegan = vegan;
    }
}
