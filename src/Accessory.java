public class Accessory extends EquippableItem implements Equip{

    public Accessory(String name, int value, int sellValue, int secondaryValue) {
        super(name, value, sellValue, secondaryValue);
    }

    @Override
    public void equip(Character c) {
        c.setAccessory(this);
    }
}
