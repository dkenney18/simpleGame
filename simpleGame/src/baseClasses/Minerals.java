package baseClasses;

public class Minerals extends Item {
    int value;
    public enum  MineralType {DIAMOND, GOLD, IRON, RUBY, EMERALD, ONYX}
    public enum MineralRarity {COMMON, UNCOMMON, RARE, LEGENDARY}
    MineralRarity mineralRarity;
    MineralType mineralType;

    public void setValue(int value) {
        this.value = value;
    }

    public void setMineralType(MineralType mineralType) {
        this.mineralType = mineralType;
    }

    public void setMineralRarity(MineralRarity mineralRarity) {
        this.mineralRarity = mineralRarity;
    }

    //get
    public int getValue() {
        return value;
    }

    public MineralType getMineralType() {
        return mineralType;
    }

    public MineralRarity getMineralRarity() {
        return mineralRarity;
    }
}
