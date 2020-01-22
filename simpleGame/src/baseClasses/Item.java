package baseClasses;

public class Item {
    public enum ItemType {WEAPON, FOOD, STORAGE, ARMOR}

    ItemType itemType;
    String name;
    int cost;
    int durability;
    int count = 1;

    //getters
    public int getDurability() {
        return durability;
    }

    public int getCost() {
        return cost;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    //setters
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void addCount(int additional) {
        count += additional;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
