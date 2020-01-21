package player;

import armor.Armor;
import baseClasses.Entity;
import baseClasses.Food;
import storage.Backpack;
import weapon.Weapon;

import java.util.ArrayList;

public class Player extends Entity {
    Weapon leftHand;
    Weapon RightHand;
    Backpack backpack;

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
}
