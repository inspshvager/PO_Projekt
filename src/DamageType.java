public enum DamageType {
    ONE,
    ALL,
    SPLASH;

    public static DamageType parseString(String s){
        return switch (s) {
            case "ONE" -> DamageType.ONE;
            case "ALL" -> DamageType.ALL;
            case "SPLASH" -> DamageType.SPLASH;
            default -> throw new IllegalArgumentException("Błędne dane: " + s);
        };
    }
}