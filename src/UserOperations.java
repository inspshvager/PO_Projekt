public class UserOperations {
    static String characterName;
    static String input;
    // Metoda do tworzenia nowej postaci z poziomu użytkownika
    public static Character createCharacter() {
        System.out.println("Podaj imię postaci");
        characterName = Data.readStringInput.nextLine();
        do{
            System.out.println("Wybierze klasę postaci");
            System.out.println("1. Rycerz\n2. Czarny Mag\n3. Biały Mag\n4. Złodziej");
            input = Data.readStringInput.nextLine();
            if(isDigits(input)){
                switch (Integer.parseInt(input)) {
                    case 1:
                        return new Character(characterName, 200, 20, 15, 20, 5, 15, 10, 0);
                    case 2:
                        return new Character(characterName, 100, 50, 5, 10, 25, 20, 15, 0);
                    case 3:
                        return new Character(characterName, 125, 40, 5, 15, 20, 25, 12, 0);
                    case 4:
                        return new Character(characterName, 150, 30, 15, 15, 10, 15, 20, 0);
                    default:
                        System.out.println("Niepoprawna odpowiedź, wprowadź dane jeszcze raz.");
                }
            }
            else{
                System.out.println("Niepoprawne dane!");
            }

        }
        while (true);
    }

    // Metoda wypisująca dane postaci
    public static void readCharacter(Character c){
        System.out.println(c.getName());
        System.out.println("==========");
        System.out.println("HP: " + c.getHp() +
                "\nMP: " + c.getMp() +
                "\nAtak: " + (c.getAttack() + (c.getWeapon() == null ? 0 : c.getWeapon().getValue())) +
                "\nObrona: " + (c.getDefense() + (c.getBody() == null ? 0 : c.getBody().getValue())) +
                "\nMagiczny atak: " + (c.getMagicAttack() + (c.getAccessory() == null ? 0 : c.getAccessory().getValue())) +
                "\nMagiczna obrona: " + (c.getMagicDefense() + (c.getHead() == null ? 0 : c.getHead().getValue())) +
                "\nSzybkość: " + c.getSpeed() +
                "\nDoświadczenie: " + c.getExp() +
                "\nBroń: " + (c.getWeapon() == null ? "--Brak--" : c.getWeapon()) +
                "\nNakrycie głowy: " + (c.getHead() == null ? "--Brak--" : c.getHead()) +
                "\nPancerz: " + (c.getBody() == null ? "--Brak--" : c.getBody()) +
                "\nAkcesorium: " + (c.getAccessory() == null ? "--Brak--" : c.getAccessory()));
    }

    // Metoda aktualizująca nazwę oraz klasę postaci
    public static void updateCharacter(Character c){
        System.out.println("Wybierz co chcesz zmienić:");
        System.out.println("""
                    1. Imię
                    2. Klasę""");
        input = Data.readStringInput.nextLine();
        if (isDigits(input)){
            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.println("Podaj nowe imię: ");
                    c.setName(Data.readStringInput.nextLine());
                    break;
                case 2:
                    System.out.println("Wybierze klasę postaci");
                    System.out.println("""
                    1. Rycerz
                    2. Czarny Mag
                    3. Biały Mag
                    4. Złodziej""");
                    input = Data.readStringInput.nextLine();
                    if (isDigits(input)) {
                        switch (Integer.parseInt(input)) {
                            case 1:
                                c.set(200, 20, 15, 20, 5, 15, 10);
                                break;
                            case 2:
                                c.set(100, 50, 5, 10, 25, 20, 15);
                                break;
                            case 3:
                                c.set(125, 40, 5, 15, 20, 25, 12);
                                break;
                            case 4:
                                c.set(150, 30, 15, 15, 10, 15, 20);
                                break;
                            default:
                                System.out.println("Niepoprawna odpowiedź, wprowadź dane jeszcze raz.");
                                break;
                        }
                    }
                    else{
                        System.out.println("Niepoprawne dane!");
                    }
                    break;
                default:
                    System.out.println("Niepoprawna odpowiedź, wprowadź dane jeszcze raz.");
            }
        }
        else{
            System.out.println("Niepoprawne dane!");
        }

    }

    // Metoda usuwająco postać
    public static void deleteCharacter() throws LastCharacterException{
        try {
            int nullCounter = 0;
            for (Character character : Data.characters) {
                if (character == null) nullCounter++;
            }
            if(nullCounter >= 3) throw new LastCharacterException("Nie można usunąć ostatniej postaci!");
            System.out.println("Wybierz postać do usunięcia:");
            for (int i = 0; i < Data.characters.length; i++) {
                if (Data.characters[i] == null) continue;
                else {
                    System.out.println((i + 1) + ". " + Data.characters[i].getName());
                }
            }
            input = Data.readStringInput.nextLine();
            if (isDigits(input)){
                switch (Integer.parseInt(input)) {
                    case 1:
                        Data.characters[0] = null;
                        break;
                    case 2:
                        Data.characters[1] = null;
                        break;
                    case 3:
                        Data.characters[2] = null;
                        break;
                    case 4:
                        Data.characters[3] = null;
                        break;
                    default:
                        break;
                }
            }
            else{
                System.out.println("Niepoprawne dane!");
            }

        }
        catch (LastCharacterException e){
            e.printStackTrace();
        }
    }
    public static boolean isDigits(String input){
        String regex = "[0-9, .]+";
        return input.matches(regex);
    }
}