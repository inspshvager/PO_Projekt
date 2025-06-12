public class HealingItem extends AItem{
    private final boolean doesRecoverHP;

    public HealingItem(String name, int value, int sellValue, boolean doesRecoverHP) {
        super(name, value, sellValue);
        this.doesRecoverHP = doesRecoverHP;
    }

    public HealingItem(boolean doesRecoverHP) {
        this.doesRecoverHP = doesRecoverHP;
    }

    public boolean isDoesRecoverHP() {
        return doesRecoverHP;
    }
}
