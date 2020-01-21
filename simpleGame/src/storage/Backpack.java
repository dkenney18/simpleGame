package storage;

import baseClasses.Item;

import java.util.ArrayList;

public class Backpack extends Item {
    ArrayList<Item> items;
    ItemType itemType = ItemType.STORAGE;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems() {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
