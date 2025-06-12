import java.util.List;
import java.util.Scanner;

public class Run {
    static Scanner readStringInput = new Scanner(System.in);
    static Scanner readIntInput = new Scanner(System.in);
    static String characterName;
    static Character[] characters = new Character[4];

    public static void runMain(){
        Character a = new Character("Cloud", 200, 20, 15, 20, 5, 15, 10, 0);
        Character b = new Character("Barret", 200, 20, 15, 20, 5, 15, 10, 0);
        Character c = new Character("Tifa", 200, 20, 15, 20, 5, 15, 10, 0);
        readCharacter(a);
        characters[0] = a;
        characters[1] = b;
        characters[3] = c;
        deleteCharacter();
        deleteCharacter();
        deleteCharacter();
        deleteCharacter();
    }

    public static Character createCharacter() {
        System.out.println("Podaj imię postaci");
        characterName = readStringInput.nextLine();
        do{
            System.out.println("Wybierze klasę postaci");
            System.out.println("""
                    1. Rycerz
                    2. Czarny Mag
                    3. Biały Mag
                    4. Złodziej""");
            switch (readIntInput.nextInt()) {
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
        while (true);
    }

    public static void readCharacter(Character c){
        System.out.println(c.getName());
        System.out.println("==========");
        System.out.println("HP: " + c.getHp() +
                "\nMP: " + c.getMp() +
                "\nAtak: " + c.getAttack() +
                "\nObrona: " + c.getDefense() +
                "\nMagiczny Atak: " + c.getMagicAttack() +
                "\nMagiczna Obrona: " + c.getMagicDefense() +
                "\nSzybkość: " + c.getSpeed() +
                "\nDoświadczenie: " + c.getExp());
    }

    public static void updateCharacter(Character c){
        System.out.println("Wybierz co chcesz zmienić:");
        System.out.println("""
                    1. Imię
                    2. Klasę""");
        switch (readIntInput.nextInt()) {
            case 1:
                System.out.println("Podaj nowe imię: ");
                c.setName(readStringInput.nextLine());
                break;
                case 2:
                    System.out.println("Wybierze klasę postaci");
                    System.out.println("""
                    1. Rycerz
                    2. Czarny Mag
                    3. Biały Mag
                    4. Złodziej""");
                    switch (readIntInput.nextInt()) {
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
                    break;
            default:
                System.out.println("Niepoprawna odpowiedź, wprowadź dane jeszcze raz.");
        }
    }

    public static void deleteCharacter(){
        if(characters[0] == null && characters[1] == null && characters[2] == null && characters[3] == null)
            System.out.println("Brak postaci do usunięcia!");
        else{
            System.out.println("Wybierz postać do usunięcia:");
            for(int i = 0; i < characters.length; i++){
                if(characters[i] == null) continue;
                else {
                    System.out.println((i+1) + ". " + characters[i].getName());
                }
            }
            switch(readIntInput.nextInt()){
                case 1:
                    characters[0] = null;
                    break;
                case 2:
                    characters[1] = null;
                    break;
                case 3:
                    characters[2] = null;
                    break;
                case 4:
                    characters[3] = null;
                    break;
                default:
                    break;
            }
        }
    }
}
