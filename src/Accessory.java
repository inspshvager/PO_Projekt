public class Accessory extends AItem implements Equip{

    public Accessory(String name, int value, int sellValue) {
        super(name, value, sellValue);
    }

    @Override
    public void equip(Character c) {
        c.setAccessory(this);
    }

    @Override
    public String toString(){
        return name;
    }
}
