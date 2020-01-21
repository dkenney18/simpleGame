package mob;

import baseClasses.Entity;
import weapon.Weapon;

import java.util.ArrayList;

public class Mob extends Entity {
    int coinDropped = 0;
    double damage;

    public void setCoinDropped(int coinDropped) {
        this.coinDropped = coinDropped;
    }

    public int getCoinDropped() {
        return coinDropped;
    }

    public void setDamage(double damage) {
            this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

}
