package storage;

import baseClasses.Item;

import java.util.ArrayList;

public class Backpack extends Item {
    ArrayList<Item> items = new ArrayList<>();
    ItemType itemType = ItemType.STORAGE;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> list) {
        this.items = list;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {this.items.remove(item);}

    public void showItems() {
        for (Item item : items) {
            System.out.println(item.getName() + " => " + item.getCount());
        }
    }
}
