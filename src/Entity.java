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

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
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
