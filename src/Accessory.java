public class Accessory extends EquippableItem implements Equip{

    public Accessory(String name, int value, int sellValue) {
        super(name, value, sellValue);
    }

    @Override
    public void equip(Character c) {
        c.setAccessory(this);
    }
}
