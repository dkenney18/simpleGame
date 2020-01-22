package weapon;

import baseClasses.Item;

public class Weapon extends Item {
    WeaponType weaponType;
    WeaponMaterial weaponMaterial;
    slot weaponSlot;
    double damage;

    //getters
    public double getDamage() {
        return damage;
    }

    //setters
    public void setDamage(double damage) {
        this.damage = damage;
    }
    //add skills later

    public slot getWeaponSlot() {
        return weaponSlot;
    }

    public void setWeaponSlot(slot weaponSlot) {
        this.weaponSlot = weaponSlot;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public WeaponMaterial getWeaponMaterial() {
        return weaponMaterial;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setWeaponMaterial(WeaponMaterial weaponMaterial) {
        this.weaponMaterial = weaponMaterial;
    }

    public enum WeaponType {SWORD, AXE, HAMMER, STAFF}

    public enum WeaponMaterial {WOOD, STONE, GOLD, IRON, DIAMOND}

    public enum slot {ONE, TWO}
}
