public class BattleItem extends AItem{
    private final DamageType damageType;

    public BattleItem(String name, int value, int sellValue, DamageType damageType) {
        super(name, value, sellValue);
        this.damageType = damageType;
    }

    public BattleItem(DamageType damageType) {
        this.damageType = damageType;
    }

    public DamageType getDamageType() {
        return damageType;
    }
}
