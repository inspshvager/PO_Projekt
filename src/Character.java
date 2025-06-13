import java.util.List;

public class Character extends Entity{
    private int mp;
    private int defense;
    private int magicAttack;
    private int magicDefense;
    private Weapon weapon = null;
    private Head head = null;
    private Body body = null;
    private Accessory accessory = null;

    public Character(String name, int hp, int mp, int attack, int defense, int magicAttack, int magicDefense, int speed, int exp){
        super(name, hp, attack, speed, exp);
        this.mp = mp;
        this.defense = defense;
        this.magicAttack = magicAttack;
        this.magicDefense = magicDefense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public void set(int hp, int mp, int attack, int defense, int magicAttack, int magicDefense, int speed){
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.defense = defense;
        this.magicAttack = magicAttack;
        this.magicDefense = magicDefense;
        this.speed = speed;
    }

    public String saveToFile(){
        return name + ";" + hp + ";" + mp + ";" + attack + ";" + defense + ";" + magicAttack + ";" + magicDefense + ";" + speed + ";" + exp;
    }

    public void unEquip(Weapon w){
        this.weapon = null;
    }

    public void unEquip(Head h){
        this.head = null;
    }

    public void unEquip(Body b){
        this.body = null;
    }

    public void unEquip(Accessory a){
        this.accessory = null;
    }

    public int getMp() {
        return mp;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    @Override
    public String toString() {
        return this.getName() +"{" +
                "mp=" + mp +
                ", defense=" + defense +
                ", magicAttack=" + magicAttack +
                ", magicDefense=" + magicDefense +
                ", weapon=" + weapon +
                ", head=" + head +
                ", body=" + body +
                ", accessory=" + accessory +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", speed=" + speed +
                ", exp=" + exp +
                '}';
    }
}
