public class Head extends EquippableItem implements Equip{

    public Head(String name, int value, int sellValue, int secondaryValue) {
        super(name, value, sellValue, secondaryValue);
    }

    @Override
    public void equip(Character c) {
        c.setHead(this);
    }
}
