public class Body extends EquippableItem implements Equip{

    public Body(String name, int value, int sellValue, int secondaryValue) {
        super(name, value, sellValue, secondaryValue);
    }

    @Override
    public void equip(Character c) {
        c.setBody(this);
    }
}
