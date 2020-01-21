package baseClasses;

public class Item {
    public enum ItemType {WEAPON, FOOD, STORAGE, ARMOR}

    ItemType itemType;
    String name;
    int cost;
    int durability;

    //getters
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
}
