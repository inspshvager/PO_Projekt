public class Enemy extends Entity{
    private final int money;

    public Enemy(String name, int hp, int attack, int speed, int exp, int money) {
        super(name, hp, attack, speed, exp);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
