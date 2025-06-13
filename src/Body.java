public class Body extends EquippableItem implements Equip{

    public Body(String name, int value, int sellValue) {
        super(name, value, sellValue);
    }

    @Override
    public void equip(Character c) {
        c.setBody(this);
    }
}
