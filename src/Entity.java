public abstract class Entity {
    protected String name;
    protected int hp;
    protected int mp;
    protected int attack;
    protected int defense;
    protected int magicAttack;
    protected int magicDefense;
    protected int speed;
    protected int exp;

    public Entity(String name, int hp, int mp, int attack, int defense, int magicAttack, int magicDefense, int speed, int exp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.defense = defense;
        this.magicAttack = magicAttack;
        this.magicDefense = magicDefense;
        this.speed = speed;
        this.exp = exp;
    }

    public Entity() {
        this.name = "Unknown";
        this.hp = 1;
        this.mp = 0;
        this.attack = 1;
        this.defense = 1;
        this.magicAttack = 1;
        this.magicDefense = 1;
        this.speed = 1;
        this.exp = 1;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
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

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                '}';
    }
}
