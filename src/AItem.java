public abstract class AItem {
    protected String name;
    protected int value;
    protected int sellValue;

    public AItem(String name, int value, int sellValue) {
        this.name = name;
        this.value = value;
        this.sellValue = sellValue;
    }

    public AItem() {
        this.name = "Unknown";
        this.value = 0;
        this.sellValue = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSellValue() {
        return sellValue;
    }

    public void setSellValue(int sellValue) {
        this.sellValue = sellValue;
    }

    @Override
    public String toString() {
        return "AItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
