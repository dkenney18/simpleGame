package player;

import armor.Armor;
import baseClasses.Entity;
import baseClasses.Food;
import baseClasses.Item;
import baseClasses.Minerals;
import storage.Backpack;
import weapon.Weapon;

import java.util.ArrayList;

public class Player extends Entity {
    public boolean HelmetSlotFilled = false;
    public boolean BreastplateSlotFilled = false;
    public boolean LeggingsSlotFilled = false;
    public boolean BootSlotFilled = false;
    public boolean LeftHandFilled = false;
    public boolean RightHandFilled = false;
    public ArrayList<Armor> armorArrayList = new ArrayList<>();
    public ArrayList<Weapon> weaponArrayList = new ArrayList<>();
    public ArrayList<Food> foodArrayList = new ArrayList<>();
    public ArrayList<Item> itemArrayList = new ArrayList<>();
    Weapon leftHand;
    Weapon RightHand;
    Backpack backpack;
    double damage;
    int coins = 1000;

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

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setDamage() {
        damage = 0;
        for (int i = 0; i < weaponArrayList.size(); i++) {
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
            System.out.println(itemArrayList.get(i).getName() + " => " + itemArrayList.get(i).getCount());
        }
    }

    public void setArmorLevel(int i) {
        //helmet logic
        if (armorArrayList.get(i).getArmorSlot() == Armor.ArmorSlot.HELMET) {

            if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.LEATHER) {

                upgradeArmor(Armor.ArmorMaterial.IRON, 20, Armor.ArmorSlot.HELMET, 30, 200, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.IRON) {

                upgradeArmor(Armor.ArmorMaterial.GOLD, 50, Armor.ArmorSlot.HELMET, 45, 250, i);


            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.GOLD) {

                upgradeArmor(Armor.ArmorMaterial.DIAMOND, 150, Armor.ArmorSlot.HELMET, 100, 500, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.DIAMOND) {
                System.out.println("Highest Level Reached");
            }
        }

        //breastplate logic
        if (armorArrayList.get(i).getArmorSlot() == Armor.ArmorSlot.BREASTPLATE) {
            if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.LEATHER) {

                upgradeArmor(Armor.ArmorMaterial.IRON, 20, Armor.ArmorSlot.BREASTPLATE, 30, 200, i);


            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.IRON) {

                upgradeArmor(Armor.ArmorMaterial.GOLD, 50, Armor.ArmorSlot.BREASTPLATE, 45, 250, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.GOLD) {

                upgradeArmor(Armor.ArmorMaterial.DIAMOND, 150, Armor.ArmorSlot.BREASTPLATE, 100, 500, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.DIAMOND) {
                System.out.println("Highest Level Reached");
            }
        }

        //legging logic
        if (armorArrayList.get(i).getArmorSlot() == Armor.ArmorSlot.LEGGINGS) {
            if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.LEATHER) {

                upgradeArmor(Armor.ArmorMaterial.IRON, 20, Armor.ArmorSlot.LEGGINGS, 30, 200, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.IRON) {
                upgradeArmor(Armor.ArmorMaterial.GOLD, 50, Armor.ArmorSlot.LEGGINGS, 45, 250, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.GOLD) {

                upgradeArmor(Armor.ArmorMaterial.DIAMOND, 150, Armor.ArmorSlot.LEGGINGS, 100, 500, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.DIAMOND) {
                System.out.println("Highest Level Reached");
            }
        }

        //boot logic
        if (armorArrayList.get(i).getArmorSlot() == Armor.ArmorSlot.BOOTS) {
            if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.LEATHER) {

                upgradeArmor(Armor.ArmorMaterial.IRON, 20, Armor.ArmorSlot.BOOTS, 30, 200, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.IRON) {

                upgradeArmor(Armor.ArmorMaterial.GOLD, 50, Armor.ArmorSlot.BOOTS, 45, 250, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.GOLD) {

                upgradeArmor(Armor.ArmorMaterial.DIAMOND, 150, Armor.ArmorSlot.BOOTS, 100, 500, i);

            } else if (armorArrayList.get(i).getArmorMaterial() == Armor.ArmorMaterial.DIAMOND) {
                System.out.println("Highest Level Reached");
            }
        }
    }

    //sets armor level to the next step and charges player accordingly
    public void upgradeArmor(Armor.ArmorMaterial material, int cost, Armor.ArmorSlot slot, int health, int durability, int i) {
        armorArrayList.get(i).setArmorMaterial(material);
        armorArrayList.get(i).setCost(cost);
        armorArrayList.get(i).setArmorSlot(slot);
        armorArrayList.get(i).setHealth(health);
        armorArrayList.get(i).setDurability(durability);
        armorArrayList.get(i).setName(armorArrayList.get(i).getArmorMaterial().toString() + " " + armorArrayList.get(i).getArmorSlot().toString());

        coins -= armorArrayList.get(i).getCost();

        addHealth();

        System.out.println("Upgraded to: " + armorArrayList.get(i).getName());
        System.out.println("You have: " + coins + " coin(s) left");
    }

    public void setWeaponLevel(int i) {

        System.out.println(weaponArrayList.get(i).getWeaponMaterial());

        if (weaponArrayList.get(i).getWeaponMaterial() == Weapon.WeaponMaterial.WOOD) {

            upgradeWeapon(Weapon.WeaponMaterial.STONE,(weaponArrayList.get(i).getCost() + 50) , (weaponArrayList.get(i).getDamage() + 20), (weaponArrayList.get(i).getDurability() + 100), i);

        } else  if (weaponArrayList.get(i).getWeaponMaterial() == Weapon.WeaponMaterial.STONE) {

            upgradeWeapon(Weapon.WeaponMaterial.IRON,(weaponArrayList.get(i).getCost() + 50) , (weaponArrayList.get(i).getDamage() + 20), (weaponArrayList.get(i).getDurability() + 100), i);

        } else  if (weaponArrayList.get(i).getWeaponMaterial() == Weapon.WeaponMaterial.IRON) {

            upgradeWeapon(Weapon.WeaponMaterial.GOLD,(weaponArrayList.get(i).getCost() + 50) , (weaponArrayList.get(i).getDamage() + 20), (weaponArrayList.get(i).getDurability() + 100), i);

        } else  if (weaponArrayList.get(i).getWeaponMaterial() == Weapon.WeaponMaterial.GOLD) {

            upgradeWeapon(Weapon.WeaponMaterial.DIAMOND,(weaponArrayList.get(i).getCost() + 50) , (weaponArrayList.get(i).getDamage() + 20), (weaponArrayList.get(i).getDurability() + 100), i);

        } else  if (weaponArrayList.get(i).getWeaponMaterial() == Weapon.WeaponMaterial.DIAMOND) {

            System.out.println("Highest Level Reached");
        }
    }

    public void upgradeWeapon(Weapon.WeaponMaterial material, int cost, double damage, int durability, int i) {
        weaponArrayList.get(i).setDamage(damage);
        weaponArrayList.get(i).setCost(cost);
        weaponArrayList.get(i).setWeaponMaterial(material);
        weaponArrayList.get(i).setDurability(durability);

        weaponArrayList.get(i).setName(weaponArrayList.get(i).getWeaponMaterial() + " " + weaponArrayList.get(i).getWeaponType());

        coins -= weaponArrayList.get(i).getCost();

        setDamage();

        System.out.println("Upgraded to: " + weaponArrayList.get(i).getName());
        System.out.println("You have: " + coins + " coin(s) left");
    }
}