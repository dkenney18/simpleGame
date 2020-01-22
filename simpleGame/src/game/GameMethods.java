package game;

import armor.Armor;
import baseClasses.Food;
import baseClasses.Item;
import baseClasses.Minerals;
import minerals.Ruby;
import mob.Mob;
import player.Player;
import storage.Backpack;
import weapon.Weapon;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

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

    public void UpgradeArmor(Player player) {

        for (int i = 0; i < player.armorArrayList.size(); i++) {
            System.out.println("ID: " + i + " " + player.armorArrayList.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (ans <= player.armorArrayList.size()) {
            player.setArmorLevel(ans);
        } else {
            System.out.println("Number is out of Bounds");
        }
    }

    public void UpgradeWeapon(Player player) throws InputMismatchException {
        for (int i = 0; i < player.weaponArrayList.size(); i++) {
            System.out.println("ID: " + i + " " + player.weaponArrayList.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if (ans <= player.weaponArrayList.size()) {
            player.setWeaponLevel(ans);
        } else {
            System.out.println("Number is out of Bounds");
        }
    }

    //set up fighting
    public void fight(Mob mob, Player player) {
        int monstersBeat = 0;
        int coinsGathered = 0;

        System.out.println("Fighting: " + mob.getName());

        while (player.getHealth() > 0) {
            player.setHealth((player.getHealth() - mob.getDamage()));
            mob.setHealth((mob.getHealth() - player.getDamage()));
            if (mob.getHealth() <= 0) {
                monstersBeat += 1;
                coinsGathered += mob.getCoinDropped();
                player.setCoins(player.getCoins() + mob.getCoinDropped());
                mob.setHealth(50);
            }
             if (player.getHealth() <= 0) {
                 System.out.println("You died!");
                 break;
             }
        }
        System.out.println("You beat: " + monstersBeat + " monster(s) and gathered: " + coinsGathered + " coin(s)");
        player.addHealth();
    }

    //set up foraging
    public void forage(Player player, ArrayList<Minerals> mineralsArrayList) {

        //this sets up a very simple but effective way to create loot chances
        Random rand = new Random();
        int chancesForCommon = rand.nextInt(3);
        int chancesForUncommon = rand.nextInt(500);
        int chancesForRare = rand.nextInt(1000);
        int chancesForLegendary =  rand.nextInt(10000);

        ArrayList<Minerals> commonMinerals = new ArrayList<>();
        ArrayList<Minerals> uncommonMinerals = new ArrayList<>();
        ArrayList<Minerals> rareminerals = new ArrayList<>();
        ArrayList<Minerals> legendaryMinerals = new ArrayList<>();

        //sets up a lists of mineral rarity to give you a random item from it
        for (int i = 0; i < mineralsArrayList.size() ; i++) {

            if (mineralsArrayList.get(i).getMineralRarity() == Minerals.MineralRarity.COMMON)
            {
                commonMinerals.add(mineralsArrayList.get(i));

            } else if (mineralsArrayList.get(i).getMineralRarity() == Minerals.MineralRarity.UNCOMMON) {

                uncommonMinerals.add(mineralsArrayList.get(i));

            } else if (mineralsArrayList.get(i).getMineralRarity() == Minerals.MineralRarity.RARE) {

                rareminerals.add(mineralsArrayList.get(i));

            } else if (mineralsArrayList.get(i).getMineralRarity() == Minerals.MineralRarity.LEGENDARY) {

                legendaryMinerals.add(mineralsArrayList.get(i));
            }
        }
        while (true) {

            chancesForCommon = rand.nextInt(10);
            chancesForUncommon = rand.nextInt(50);
            chancesForRare = rand.nextInt(100);
            chancesForLegendary =  rand.nextInt(1000);
            Scanner sc = new Scanner(System.in);

            //common items
            if (chancesForCommon == 1) {
                int random = rand.nextInt(commonMinerals.size());

                if (!player.itemArrayList.contains(commonMinerals.get(random))) {
                    player.itemArrayList.add(commonMinerals.get(random));
                }
                commonMinerals.get(commonMinerals.size() - 1).addCount(1);
                System.out.println("Yay you found a common mineral");
            }

            //uncommon items
            if (chancesForUncommon == 40) {
                int random = rand.nextInt(uncommonMinerals.size());

                if (!player.itemArrayList.contains(uncommonMinerals.get(random))) {
                    player.itemArrayList.add(uncommonMinerals.get(random));
                }
                uncommonMinerals.get(uncommonMinerals.size() - 1).addCount(1);
                System.out.println("Yay you found an uncommon mineral");
            }


            //rare items
            if (chancesForRare == 70) {
                int random = rand.nextInt(rareminerals.size());

                if (!player.itemArrayList.contains(rareminerals.get(random))) {
                    player.itemArrayList.add(rareminerals.get(random));
                }
                rareminerals.get(rareminerals.size() - 1).addCount(1);
                System.out.println("Yay you found a rare mineral");
            }

            //chances for legendary
            if (chancesForLegendary == 5000) {
                int random = rand.nextInt(legendaryMinerals.size());

                if (!player.itemArrayList.contains(legendaryMinerals.get(random))) {
                    player.itemArrayList.add(legendaryMinerals.get(random));
                }
                legendaryMinerals.get(legendaryMinerals.size() - 1).addCount(1);
                System.out.println("Yay you found a legendary mineral");
            }

            System.out.println("press any key to continue press e to exit");
            String ans = sc.nextLine();
            if (ans.equals("e".toLowerCase())) {
                break;
            }
        }
    }

    //buy armor
    private void buyArmor(Player player, ArrayList<Armor> armors, int ans) {
        player.armorArrayList.add(armors.get(ans));
        player.setCoins((player.getCoins() - armors.get(ans).getCost()));
        player.addHealth();
        System.out.println("Bought: " + armors.get(ans).getName());
    }

    //buy armor
    private void buyWeapon(Player player, ArrayList<Weapon> weapons, int ans) {
        player.weaponArrayList.add(weapons.get(ans));
        player.weaponArrayList.get(player.weaponArrayList.size() - 1).setWeaponMaterial(Weapon.WeaponMaterial.WOOD);
        player.setCoins((player.getCoins() - weapons.get(ans).getCost()));
        player.setDamage();
        System.out.println("Bought: " + weapons.get(ans).getName());
    }

    //buy food
    private void buyFood(Player player, ArrayList<Food> foods, int ans) {
        player.foodArrayList.add(foods.get(ans));
        player.setCoins((player.getCoins() - foods.get(ans).getCost()));
        System.out.println("Bought: " + foods.get(ans).getName());
    }
}
