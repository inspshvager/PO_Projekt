public enum ItemType {
    HEALING,
    BATTLE,
    WEAPON,
    HEAD,
    BODY,
    ACCESSORY;

    public static ItemType parseString(String s){
        return switch (s) {
            case "HEALING" -> ItemType.HEALING;
            case "BATTLE" -> ItemType.BATTLE;
            case "WEAPON" -> ItemType.WEAPON;
            case "HEAD" -> ItemType.HEAD;
            case "BODY" -> ItemType.BODY;
            case "ACCESSORY" -> ItemType.ACCESSORY;
            default -> throw new IllegalArgumentException("Błędne dane: " + s);
        };
    }
}
