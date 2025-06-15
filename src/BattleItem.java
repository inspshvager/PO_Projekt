public class BattleItem extends AItem{
    // Pole
    private final DamageType damageType;

    // Konstruktor
    public BattleItem(String name, int value, int sellValue, DamageType damageType) {
        super(name, value, sellValue);
        this.damageType = damageType;
    }

    // Getter
    public DamageType getDamageType() {
        return damageType;
    }
}
