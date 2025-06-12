public class Action {
    private final String actionName;
    private final boolean doesTargetEnemy;
    private final DamageType damageType;
    private final int value;
    private final int cost;

    public Action(String actionName, boolean doesTargetEnemy, DamageType damageType, int value, int cost) {
        this.actionName = actionName;
        this.doesTargetEnemy = doesTargetEnemy;
        this.damageType = damageType;
        this.value = value;
        this.cost = cost;
    }

    public Action() {
        this.actionName = null;
        this.doesTargetEnemy = true;
        this.damageType = DamageType.ONE;
        this.value = 1;
        this.cost = 0;
    }

    public String getActionName() {
        return actionName;
    }

    public boolean isDoesTargetEnemy() {
        return doesTargetEnemy;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Action{" +
                "actionName='" + actionName + '\'' +
                '}';
    }
}