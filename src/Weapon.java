public class Weapon extends AItem  implements Equip {
    public Weapon(String name, int value, int sellValue) {
        super(name, value, sellValue);
    }

    @Override
    public void equip(Character c) {
        c.setWeapon(this);
    }

    @Override
    public String toString(){
        return name;
    }
}
