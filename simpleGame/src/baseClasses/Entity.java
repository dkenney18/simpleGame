package baseClasses;

public class Entity {
    String name;
    double health;


    //set
    public void setHealth(double health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    //get

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }
}
