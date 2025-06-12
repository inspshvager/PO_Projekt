import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    static Scanner readStringInput = new Scanner(System.in);
    static Scanner readIntInput = new Scanner(System.in);
    static String characterName;
    static Character[] characters = new Character[4];
    static ArrayList<AItem> itemList = new ArrayList<>();
    static ArrayList<Enemy> enemyList = new ArrayList<>();

    public static void runMain() throws IOException {
        loadCharacters();
        System.out.println(characters[0].toString());
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

    public static void saveCharacters() throws IOException {
        if(characters[0] == null && characters[1] == null && characters[2] == null && characters[3] == null)
            System.out.println("Brak postaci do zapisania!");
        else{
            try {
                File saveFile = new File("src/data/save.txt");
                FileWriter saveFileWriter = new FileWriter(saveFile);
                for (int i = 0; i < characters.length; i++){
                    if(characters[i] == null) continue;
                    else{
                        saveFileWriter.write(characters[i].saveToFile() + "\n");
                    }
                }
                saveFileWriter.close();
                System.out.println("Success!");
            }
            catch (IOException e){
                System.out.println("Wystąpił błąd!");
                e.printStackTrace();
            }
        }
    }

    public static void loadCharacters() throws IOException {
        try {
            String characterName;
            int hp, mp, attack, defense, magicAttack, magicDefense, speed, exp, i = 0;
            File items = new File("src/data/save.txt");
            Scanner saveReader = new Scanner(items);
            while (saveReader.hasNextLine()) {
                String data = saveReader.nextLine();
                String[] dataArray = data.split(";");
                characterName = dataArray[0];
                hp = Integer.parseInt(dataArray[1]);
                mp = Integer.parseInt(dataArray[2]);
                attack = Integer.parseInt(dataArray[3]);
                defense = Integer.parseInt(dataArray[4]);
                magicAttack = Integer.parseInt(dataArray[5]);
                magicDefense = Integer.parseInt(dataArray[6]);
                speed = Integer.parseInt(dataArray[7]);
                exp = Integer.parseInt(dataArray[8]);
                characters[i] = new Character(characterName, hp, mp, attack, defense, magicAttack, magicDefense, speed, exp);
                i++;
                }
            saveReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
            e.printStackTrace();
        }
    }

    public static DamageType parseDamageType(int i){
        return switch (i) {
            case 0 -> DamageType.ONE;
            case 1 -> DamageType.ALL;
            case 2 -> DamageType.SPLASH;
            default -> throw new IllegalStateException("Błędne dane: " + i);
        };
    }

    public static void readItems() throws FileNotFoundException {
        try {
            String itemName;
            int value, sellValue, secondaryValue;
            double accuracy, critChance;
            boolean doesRecoverHP;
            DamageType damageType;
            File items = new File("src/data/items.txt");
            Scanner itemsReader = new Scanner(items);
            while (itemsReader.hasNextLine()) {
                String data = itemsReader.nextLine();
                String[] dataArray = data.split(";");
                itemName = dataArray[1].replace("_", " ");
                value = Integer.parseInt(dataArray[2]);
                sellValue = Integer.parseInt(dataArray[3]);
                switch (Integer.parseInt(dataArray[0])){
                    case 0:
                        doesRecoverHP = Boolean.parseBoolean(dataArray[4]);
                        itemList.add(new HealingItem(itemName, value, sellValue, doesRecoverHP));
                        break;
                    case 1:
                        damageType = parseDamageType(Integer.parseInt(dataArray[4]));
                        itemList.add(new BattleItem(itemName, value, sellValue, damageType));
                        break;
                    case 2:
                        secondaryValue = Integer.parseInt(dataArray[4]);
                        accuracy = Double.parseDouble(dataArray[5]);
                        critChance = Double.parseDouble(dataArray[6]);
                        itemList.add(new Weapon(itemName, value, sellValue, secondaryValue, accuracy, critChance));
                        break;
                    case 3:
                        secondaryValue = Integer.parseInt(dataArray[4]);
                        itemList.add(new Head(itemName, value, sellValue, secondaryValue));
                        break;
                    case 4:
                        secondaryValue = Integer.parseInt(dataArray[4]);
                        itemList.add(new Body(itemName, value, sellValue, secondaryValue));
                        break;
                    case 5:
                        secondaryValue = Integer.parseInt(dataArray[4]);
                        itemList.add(new Accessory(itemName, value, sellValue, secondaryValue));
                        break;
                }
            }
            itemsReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
            e.printStackTrace();
        }
    }
}
