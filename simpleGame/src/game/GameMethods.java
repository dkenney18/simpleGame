package game;

import armor.Armor;
import baseClasses.Food;
import mob.Mob;
import player.Player;
import storage.Backpack;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMethods {

    String message = "Enter id of item you want to buy,  enter 99 to exit";

    //set up a shop to buy items
    public void shopArmor(ArrayList<Armor> armors, Player player) {

        for (int i = 0; i < armors.size(); i++) {
            System.out.println("ID: " + i + " " + armors.get(i).getName());
        }

        System.out.println(message);

        while (true) {
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (ans == 99) {
                break;
            } else if (ans < armors.size() && player.armorArrayList.size() <= 4) {
                if (armors.get(ans).getArmorSlot() == Armor.ArmorSlot.HELMET && !player.HelmetSlotFilled) {

                    buyArmor(player, armors, ans);
                    player.HelmetSlotFilled = true;
                    break;

                } else if (armors.get(ans).getArmorSlot() == Armor.ArmorSlot.BREASTPLATE && !player.BreastplateSlotFilled) {

                    buyArmor(player, armors, ans);
                    player.BreastplateSlotFilled = true;
                    break;

                } else if (armors.get(ans).getArmorSlot() == Armor.ArmorSlot.LEGGINGS && !player.LeggingsSlotFilled) {

                    buyArmor(player, armors, ans);
                    player.LeggingsSlotFilled = true;
                    break;

                } else if (armors.get(ans).getArmorSlot() == Armor.ArmorSlot.BOOTS && !player.BootSlotFilled) {

                    buyArmor(player, armors, ans);
                    player.BootSlotFilled = true;
                    break;

                } else {
                    System.out.println("Unable to buy that that item");
                    break;
                }

            } else {
                System.out.println("Something went wrong");
            }
        }

    }

    public void shopWeapons(ArrayList<Weapon> weapons, Player player) {

        for (int i = 0; i < weapons.size(); i++) {
            System.out.println("ID: " + i + " " + weapons.get(i).getName());
        }

        System.out.println(message);

        while (true) {
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (ans == 99) {
                break;
            } else if (ans < weapons.size() && player.weaponArrayList.size() <= 2) {
                if (!player.LeftHandFilled) {
                    buyWeapon(player, weapons, ans);
                    player.LeftHandFilled = true;
                    player.setLeftHand(weapons.get(ans));
                    break;

                } else if (!player.RightHandFilled) {
                    buyWeapon(player, weapons, ans);

                    player.RightHandFilled = true;
                    player.setRightHand(weapons.get(ans));
                    break;
                } else {

                    System.out.println("Unable to buy that that item");
                    break;
                }

            } else {
                System.out.println("Something went wrong");
            }
        }

    }

    public void shopFood(ArrayList<Food> foods, Player player) {

        for (int i = 0; i < foods.size(); i++) {
            System.out.println("ID: " + i + " " + foods.get(i).getName());
        }

        System.out.println(message);

        while (true) {
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (ans == 99) {
                break;
            } else if (ans < foods.size() && player.foodArrayList.size() <= 4) {
                buyFood(player, foods, ans);
                break;
            } else {
                System.out.println("Something went wrong");
            }
        }

    }

    public void UpgradeArmor(ArrayList<Armor> armors, Player player) {

    }


    //set up fighting
    public void fight(Mob mob) {

    }

    //set up foraging
    public void forage(Player player, Backpack inventory) {

    }

    //buy armor
    private void buyArmor(Player player, ArrayList<Armor> armors, int ans) {
        player.armorArrayList.add(armors.get(ans));
        player.setCoins((player.getCoins() - armors.get(ans).getCost()));
        System.out.println("Bought: " + armors.get(ans).getName());
    }

    //buy armor
    private void buyWeapon(Player player, ArrayList<Weapon> weapons, int ans) {
        player.weaponArrayList.add(weapons.get(ans));
        player.setCoins((player.getCoins() - weapons.get(ans).getCost()));
        System.out.println("Bought: " + weapons.get(ans).getName());
    }

    //buy food

    private void buyFood(Player player, ArrayList<Food> foods, int ans) {
        player.foodArrayList.add(foods.get(ans));
        player.setCoins((player.getCoins() - foods.get(ans).getCost()));
        System.out.println("Bought: " + foods.get(ans).getName());
    }
}
