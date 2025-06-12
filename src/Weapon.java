public class Weapon extends EquippableItem  implements Equip {
    private final double accuracy;
    private final double critChance;

    public Weapon(String name, int value, int sellValue, int secondaryValue, double accuracy, double critChance) {
        super(name, value, sellValue, secondaryValue);
        this.accuracy = accuracy;
        this.critChance = critChance;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getCritChance() {
        return critChance;
    }

    @Override
    public void equip(Character c) {
        c.setWeapon(this);
    }
}
