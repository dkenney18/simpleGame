package player;

import armor.Armor;
import baseClasses.Entity;
import baseClasses.Food;
import baseClasses.Item;
import storage.Backpack;
import weapon.Weapon;

import java.util.ArrayList;

public class Player extends Entity {
    Weapon leftHand;
    Weapon RightHand;
    Backpack backpack;

    double damage;

    public boolean HelmetSlotFilled = false;
    public boolean BreastplateSlotFilled = false;
    public boolean LeggingsSlotFilled = false;
    public boolean BootSlotFilled = false;
    public boolean LeftHandFilled = false;
    public boolean RightHandFilled = false;

    int coins = 1000;
    public ArrayList<Armor> armorArrayList = new ArrayList<>();
    public ArrayList<Weapon> weaponArrayList = new ArrayList<>();
    public ArrayList<Food> foodArrayList = new ArrayList<>();
    public ArrayList<Item> itemArrayList = new ArrayList<>();

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Weapon getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Weapon leftHand) {
        this.leftHand = leftHand;
    }

    public Weapon getRightHand() {
        return RightHand;
    }

    public void setRightHand(Weapon rightHand) {
        RightHand = rightHand;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setDamage() {
        damage = 0;
        for (int i = 0; i < weaponArrayList.size() ; i++) {
            this.damage += weaponArrayList.get(i).getDamage();
            System.out.println(damage);
        }
    }

    public double getDamage() {
        return damage;
    }


    public void addHealth() {
        int health = 0;
        for (int i = 0; i < armorArrayList.size(); i++) {
            health += armorArrayList.get(i).getHealth();
            System.out.println(health);
        }
        setHealth(health);
    }

    public void showItemInventory() {
        for (int i = 0; i < itemArrayList.size(); i++) {
            System.out.println(itemArrayList.get(i).getName());
        }
    }
}
