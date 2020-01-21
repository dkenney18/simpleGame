package armor;

import baseClasses.Item;


public class Armor extends Item {
    int health;

    public enum ArmorSlot {HELMET, BREASTPLATE, LEGGINGS, BOOTS}

    public enum ArmorMaterial {LEATHER, IRON, GOLD, DIAMOND}

    ArmorMaterial armorMaterial;
    ArmorSlot armorSlot;
    ItemType itemType = ItemType.ARMOR;

    //set
    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmorMaterial(ArmorMaterial armorMaterial) {
        this.armorMaterial = armorMaterial;
    }

    public void setArmorSlot(ArmorSlot armorType) {
        this.armorSlot = armorType;
    }

    //get
    public ArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    public ArmorSlot getArmorSlot() {
        return armorSlot;
    }

    public int getHealth() {
        return health;
    }
}
