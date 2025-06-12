public class Weapon extends EquippableItem{
    private final double accuracy;
    private final int critChance;

    public Weapon(String name, int value, int sellValue, int secondaryValue, double accuracy, int critChance) {
        super(name, value, sellValue, secondaryValue);
        this.accuracy = accuracy;
        this.critChance = critChance;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public int getCritChance() {
        return critChance;
    }
}
