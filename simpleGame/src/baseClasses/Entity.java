package baseClasses;

public class Entity {
    String name;
    double health;
    double damage;

    //set
    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    //get

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public double getHealth() {
        return health;
    }
}
