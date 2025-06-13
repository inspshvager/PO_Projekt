public abstract class Entity {
    protected String name;
    protected int hp;
    protected int attack;
    protected int speed;
    protected int exp;

    public Entity(String name, int hp, int attack, int speed, int exp) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        this.exp = exp;
    }

    public Entity() {
        this.name = "Unknown";
        this.hp = 1;
        this.attack = 1;
        this.speed = 1;
        this.exp = 1;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                '}';
    }
}
