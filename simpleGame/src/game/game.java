package game;

import armor.Armor;
import baseClasses.Food;
import baseClasses.Item;
import food.Apple;
import mob.Mob;
import player.Player;
import storage.Backpack;
import weapon.*;

import java.util.ArrayList;
import java.util.Scanner;

public class game {

    public static void main(String[] args) {
        //set up armor
        ArrayList<Armor> armor = new ArrayList<>();
        Armor Helmet = new Armor();
        Armor Breastplate = new Armor();
        Armor Leggings = new Armor();
        Armor Boots = new Armor();

        //set up weapons
        ArrayList<Weapon> weapons = new ArrayList<>();
        Sword sword = new Sword();
        Axe axe = new Axe();
        Hammer hammer = new Hammer();
        Staff staff = new Staff();

        //set up player
        Player player = new Player();

        //set up mobs
        Mob darkMob = new Mob();

        //set up inventory
        Backpack inventory = new Backpack();

        //set up food
        ArrayList<Food> foods = new ArrayList<>();
        Apple apple = new Apple();

        //setup game methods
        GameMethods gameMethods = new GameMethods();

        //armor set
        Helmet.setCost(10);
        Helmet.setArmorMaterial(Armor.ArmorMaterial.LEATHER);
        Helmet.setArmorSlot(Armor.ArmorSlot.HELMET);
        Helmet.setHealth(15);
        Helmet.setDurability(100);
        Helmet.setItemType(Item.ItemType.ARMOR);
        Helmet.setName(Helmet.getArmorMaterial().toString() + " " + Helmet.getArmorSlot().toString());

        Breastplate.setCost(10);
        Breastplate.setArmorMaterial(Armor.ArmorMaterial.LEATHER);
        Breastplate.setArmorSlot(Armor.ArmorSlot.BREASTPLATE);
        Breastplate.setHealth(15);
        Breastplate.setDurability(100);
        Breastplate.setItemType(Item.ItemType.ARMOR);
        Breastplate.setName(Breastplate.getArmorMaterial().toString() + " " + Breastplate.getArmorSlot().toString());

        Leggings.setCost(10);
        Leggings.setArmorMaterial(Armor.ArmorMaterial.LEATHER);
        Leggings.setArmorSlot(Armor.ArmorSlot.LEGGINGS);
        Leggings.setHealth(15);
        Leggings.setDurability(100);
        Leggings.setItemType(Item.ItemType.ARMOR);
        Leggings.setName(Leggings.getArmorMaterial().toString() + " " + Leggings.getArmorSlot().toString());

        Boots.setCost(10);
        Boots.setArmorMaterial(Armor.ArmorMaterial.LEATHER);
        Boots.setArmorSlot(Armor.ArmorSlot.BOOTS);
        Boots.setHealth(15);
        Boots.setDurability(100);
        Boots.setItemType(Item.ItemType.ARMOR);
        Boots.setName(Boots.getArmorMaterial().toString() + " " + Boots.getArmorSlot().toString());

        //set weapons
        sword.setCost(15);
        sword.setDurability(50);
        sword.setItemType(Item.ItemType.WEAPON);
        sword.setName(Weapon.WeaponMaterial.WOOD.toString() + " " + Weapon.WeaponType.SWORD.toString());
        sword.setDamage(5);
        sword.setWeaponType(Weapon.WeaponType.SWORD);

        staff.setCost(10);
        staff.setDurability(15);
        staff.setItemType(Item.ItemType.WEAPON);
        staff.setName(Weapon.WeaponMaterial.WOOD.toString() + " " + Weapon.WeaponType.STAFF.toString());
        staff.setDamage(2);
        staff.setWeaponType(Weapon.WeaponType.STAFF);

        hammer.setCost(30);
        hammer.setDurability(70);
        hammer.setItemType(Item.ItemType.WEAPON);
        hammer.setName(Weapon.WeaponMaterial.WOOD.toString() + " " + Weapon.WeaponType.HAMMER.toString());
        hammer.setDamage(8);
        hammer.setWeaponType(Weapon.WeaponType.HAMMER);

        axe.setCost(20);
        axe.setDurability(30);
        axe.setItemType(Item.ItemType.WEAPON);
        axe.setName(Weapon.WeaponMaterial.WOOD.toString() + " " + Weapon.WeaponType.AXE.toString());
        axe.setDamage(6);
        axe.setWeaponType(Weapon.WeaponType.AXE);

        //setup player
        player.setBackpack(inventory);
        player.setDamage(1.0);
        player.setHealth(100.0);
        player.setName("Raix");

        //setup food
        apple.setCost(1);
        apple.setDurability(1);
        apple.setItemType(Item.ItemType.FOOD);
        apple.setName("Apple");
        apple.setSaturation(2.0);

        //setup mobs
        darkMob.setDamage(3);
        darkMob.setHealth(50);
        darkMob.setName("dark knight");

        //register Armor, Food, and Weapons

        armor.add(Helmet);
        armor.add(Breastplate);
        armor.add(Leggings);
        armor.add(Boots);

        weapons.add(sword);
        weapons.add(staff);
        weapons.add(hammer);
        weapons.add(axe);

        foods.add(apple);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter any key to exit, enter sa to shop armor, sw to shop weapons, and sf to shop food, and f to fight");
            String ans = sc.nextLine();

            if (ans.equals("sa".toLowerCase())) {

                gameMethods.shopArmor(armor, player);

            } else if (ans.equals("sw".toLowerCase())) {

                gameMethods.shopWeapons(weapons, player);

            } else if (ans.equals("sf".toLowerCase())) {

                gameMethods.shopFood(foods, player);

            }
            else if (ans.equals("f".toLowerCase())) {

                gameMethods.fight(darkMob);

            } else {
                break;
            }

        }
    }
}
