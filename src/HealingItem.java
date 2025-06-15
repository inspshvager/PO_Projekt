public class HealingItem extends AItem{
    // Pole
    private final boolean doesRecoverHP;

    // Konstruktor
    public HealingItem(String name, int value, int sellValue, boolean doesRecoverHP) {
        super(name, value, sellValue);
        this.doesRecoverHP = doesRecoverHP;
    }

    // Getter
    public boolean isDoesRecoverHP() {
        return doesRecoverHP;
    }
}
