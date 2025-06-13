import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Run {
    // Statyczne pola do wczytywania danych od użytkownika
    static Scanner readStringInput = new Scanner(System.in);
    static Scanner readIntInput = new Scanner(System.in);
    static String characterName;

    // Listy i tablica przechowujące dane o przedmiotach, przeciwnikach,
    // drużynie oraz ewkipunku
    static Character[] characters = new Character[4];
    static ArrayList<AItem> itemList = new ArrayList<>();
    static ArrayList<Enemy> enemyList = new ArrayList<>();
    static ArrayList<AItem> inventory = new ArrayList<>();
    static int money = 100;

    // Metoda rozpoczynająca gre
    public static void runMain() throws IOException {
        // Wczytanie danych z plików
        readEnemies();
        readItems();

        // Menu startowe - Nowa gra, kontynuacja, pomoc, itd.
        startMenu();

        // Menu główne gry
        mainMenu();
    }

    // Metoda do tworzenia nowej postaci z poziomu użytkownika
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

    // Metoda wypisująca dane postaci
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

    // Metoda aktualizująca nazwę oraz klasę postaci
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

    // Metoda usuwająco postać
    public static void deleteCharacter() throws LastCharacterException{
        try {
            int nullCounter = 0;
            for (Character character : characters) {
                if (character == null) nullCounter++;
            }
            if(nullCounter >= 3) throw new LastCharacterException("Nie można usunąć ostatniej postaci!");
            System.out.println("Wybierz postać do usunięcia:");
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] == null) continue;
                else {
                    System.out.println((i + 1) + ". " + characters[i].getName());
                }
            }
            switch (readIntInput.nextInt()) {
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
        catch (LastCharacterException e){
            e.printStackTrace();
        }
    }

    // Metoda zapisująca stan postaci do pliku tekstowego
    public static void saveCharacters() {
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

    // Metoda wczytująca stan postaci z pliku tekstowego
    public static void loadCharacters() {
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

    // Metoda wczytująca wszystkie przedmioty z pliku tekstowego
    public static void readItems() {
        try {
            String itemName;
            int value, sellValue, secondaryValue;
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
                switch (ItemType.parseString(dataArray[0])){
                    case HEALING:
                        doesRecoverHP = Boolean.parseBoolean(dataArray[4]);
                        itemList.add(new HealingItem(itemName, value, sellValue, doesRecoverHP));
                        break;
                    case BATTLE:
                        damageType = DamageType.parseString(dataArray[4]);
                        itemList.add(new BattleItem(itemName, value, sellValue, damageType));
                        break;
                    case WEAPON:
                        itemList.add(new Weapon(itemName, value, sellValue));
                        break;
                    case HEAD:
                        secondaryValue = Integer.parseInt(dataArray[3]);
                        itemList.add(new Head(itemName, value, sellValue));
                        break;
                    case BODY:
                        secondaryValue = Integer.parseInt(dataArray[3]);
                        itemList.add(new Body(itemName, value, sellValue));
                        break;
                    case ACCESSORY:
                        secondaryValue = Integer.parseInt(dataArray[3]);
                        itemList.add(new Accessory(itemName, value, sellValue));
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

    // Metoda wczytująca dane wszystkich przeciwników z pliku tekstowego
    public static void readEnemies() {
        try {
            String enemyName;
            int hp, attack, speed, exp, money;
            File enemies = new File("src/data/enemies.txt");
            Scanner enemyReader = new Scanner(enemies);
            while (enemyReader.hasNextLine()) {
                String data = enemyReader.nextLine();
                String[] dataArray = data.split(";");
                enemyName = dataArray[0].replace("_", " ");
                hp = Integer.parseInt(dataArray[1]);
                attack = Integer.parseInt(dataArray[2]);
                speed = Integer.parseInt(dataArray[3]);
                exp = Integer.parseInt(dataArray[4]);
                money = Integer.parseInt(dataArray[5]);
                enemyList.add(new Enemy(enemyName, hp, attack, speed, exp, money));
            }
            enemyReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
            e.printStackTrace();
        }
    }

    // Metoda uruchamiająca menu startowe
    public static void startMenu() throws IOException {
        System.out.println("Witaj w konsolowej grze RPG!");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1. Nowa gra\n2. Wczytaj grę\n3. Pomoc\n4. Wyjście.");
        switch (readIntInput.nextInt()){
            case 1:
                newGame();
                break;
            case 2:
                loadCharacters();
                break;
            case 3:
                helpMenu();
                break;
            default:
                System.exit(0);
        }
    }

    // Metoda rozpoczynająca nową grę
    public static void newGame(){
        System.out.println("Stwórz 4 postacie:");
        characters[0] = createCharacter();
        characters[1] = createCharacter();
        characters[2] = createCharacter();
        characters[3] = createCharacter();
        for (Character x : characters){
            System.out.println(x.getName());
        }
    }

    // Metoda wypisująca instrukcje gry
    public static void helpMenu(){
        System.out.println("Gra polega na tworzeniu postaci, wybieraniu im klasy oraz walczeniu z przeciwnikami.");
        System.out.println("Postacie mogą wyposarzać się w różne bronie oraz zdobywać doświadczenie pokonując przeciwników.");
        System.out.println("Wybierz opcje 'Nowa gra', aby rozpocząć nową grę od początku.");
        System.out.println("Wybierz opcję 'Wczytaj grę', aby wczytać grę i postęp z istniejącego pliku tekstowego.");
    }

    // Metoda wypisująca główne menu użytkownika
    public static void mainMenu() throws IOException {
        while (true){
        System.out.println("Wybierz jedną z opcji:");
        System.out.println("1. Walka\n2. Drużyna\n3. Sklep\n4. Zapis\n5. Wyjście");
        switch (readIntInput.nextInt()) {
            case 1:
                //battle();
            case 2:
                teamStatus();
                break;
            case 3:
                shop();
                break;
            case 4:
                saveCharacters();
                break;
            case 5:
                System.exit(0);
        }
        }
    }

    // Metoda do obsługi drużyny
    public static void teamStatus(){
        System.out.println("Wybierz członka drużyny:");
        int i;
        for (i = 0; i < characters.length; i++){
            if(characters[i] == null) continue;
            else{
                System.out.println((i+1) + ". " + characters[i].getName());
            }
        }
        switch (readIntInput.nextInt()){
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 3;
                break;
            default:
                break;
        }
        readCharacter(characters[i]);
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1. Wyposarzenie\n2. Edycja\n3. Usuń\n4. Wyjście");
        switch (readIntInput.nextInt()){
            case 1:
                if(inventory.isEmpty()){
                    System.out.println("Brak przedmiotów do wyposarzenia!");
                }
                else{
                    for (int j = 0; j < inventory.size(); j++){
                        System.out.println((j+1) + ". " + inventory.get(j).getName());
                    }
                    System.out.println("Wybierz przedmiot:");
                    int choice = readIntInput.nextInt();
                    if (inventory.get(choice-1) instanceof Weapon || inventory.get(choice-1) instanceof Head ||
                            inventory.get(choice-1) instanceof Body || inventory.get(choice-1) instanceof Accessory){
                        ((Equip) inventory.get(choice-1)).equip(characters[i]);
                        System.out.println("Wyposarzono przedmiot!");
                    }
                }
                break;
            case 2:
                updateCharacter(characters[i]);
            case 3:
                deleteCharacter();
            default:
                break;
        }
    }

    // Metoda do obsługi sklepu
    public static void shop(){
        Random random = new Random();
        AItem[] shopItems = new AItem[6];
        for (int i = 0; i < 6; i++) {
            shopItems[i] = itemList.get(random.nextInt(itemList.size()));
        }
        System.out.println("Witaj w sklepie!");
        System.out.println("Mam do zaoferowania dziś takie oto przedmioty!");
        for (int i = 0; i < 6; i++) {
            System.out.println((i+1) + ". " + shopItems[i].getName() + ", $" + shopItems[i].getSellValue());
        }
        switch (readIntInput.nextInt()) {
            case 1:
                if(money >= shopItems[0].getSellValue()){
                    money -= shopItems[0].getSellValue();
                    inventory.add(shopItems[0]);
                    System.out.println("Dziękuje, zapraszam ponownie!");
                }
                else{
                    System.out.println("Brak wystarczająco pieniędzy!");
                }
                break;
            case 2:
                if(money >= shopItems[1].getSellValue()){
                    money -= shopItems[1].getSellValue();
                    inventory.add(shopItems[1]);
                    System.out.println("Dziękuje, zapraszam ponownie!");
                }
                else{
                    System.out.println("Brak wystarczająco pieniędzy!");
                }
                break;
            case 3:
                if(money >= shopItems[2].getSellValue()){
                    money -= shopItems[2].getSellValue();
                    inventory.add(shopItems[2]);
                    System.out.println("Dziękuje, zapraszam ponownie!");
                }
                else{
                    System.out.println("Brak wystarczająco pieniędzy!");
                }
                break;
            case 4:
                if(money >= shopItems[3].getSellValue()){
                    money -= shopItems[3].getSellValue();
                    inventory.add(shopItems[3]);
                    System.out.println("Dziękuje, zapraszam ponownie!");
                }
                else{
                    System.out.println("Brak wystarczająco pieniędzy!");
                }
                break;
            case 5:
                if(money >= shopItems[4].getSellValue()){
                    money -= shopItems[4].getSellValue();
                    inventory.add(shopItems[4]);
                    System.out.println("Dziękuje, zapraszam ponownie!");
                }
                else{
                    System.out.println("Brak wystarczająco pieniędzy!");
                }
                break;
            case 6:
                if(money >= shopItems[5].getSellValue()){
                    money -= shopItems[5].getSellValue();
                    inventory.add(shopItems[5]);
                    System.out.println("Dziękuje, zapraszam ponownie!");
                }
                else{
                    System.out.println("Brak wystarczająco pieniędzy!");
                }
                break;
            default:
                break;
        }
    }
}