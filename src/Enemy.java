public class Enemy extends Entity{
    private final Action[] actions;
    private final boolean doesAttackRandomly;
    private final int money;

    public Enemy(Action[] actions, boolean doesAttackRandomly, int money) {
        this.actions = actions;
        this.doesAttackRandomly = doesAttackRandomly;
        this.money = money;
    }

    public Action[] getActions() {
        return actions;
    }

    public boolean isDoesAttackRandomly() {
        return doesAttackRandomly;
    }

    public int getMoney() {
        return money;
    }
}
