public abstract class EquippableItem extends AItem{
    protected final int secondaryValue;

    public EquippableItem(String name, int value, int sellValue, int secondaryValue) {
        super(name, value, sellValue);
        this.secondaryValue = secondaryValue;
    }

    public EquippableItem(int secondaryValue) {
        this.secondaryValue = secondaryValue;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }
}
