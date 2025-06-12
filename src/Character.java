import java.util.List;

public class Character extends Entity{
    private Weapon weapon = null;
    private Head head = null;
    private Body body = null;
    private Accessory accessory = null;
    private AItem[] inventory = new AItem[8];
    private List<Action> actionList = null;

    public Character(String name, int hp, int mp, int attack, int defense, int magicAttack, int magicDefense, int speed, int exp) {
        super(name, hp, mp, attack, defense, magicAttack, magicDefense, speed, exp);
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

    public AItem[] getInventory() {
        return inventory;
    }

    public void setInventory(AItem[] inventory) {
        this.inventory = inventory;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
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
}
