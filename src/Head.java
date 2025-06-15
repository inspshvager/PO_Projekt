public class Head extends AItem implements Equip{

    public Head(String name, int value, int sellValue) {
        super(name, value, sellValue);
    }

    @Override
    public void equip(Character c) {
        c.setHead(this);
    }

    @Override
    public String toString(){
        return name;
    }
}
