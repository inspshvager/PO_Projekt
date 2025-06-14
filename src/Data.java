import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    // Listy i tablica przechowujące dane o przedmiotach, przeciwnikach,
    // drużynie oraz ewkipunku
    static Character[] characters = new Character[4];
    static ArrayList<AItem> itemList = new ArrayList<>();
    static ArrayList<Enemy> enemyList = new ArrayList<>();
    static ArrayList<AItem> inventory = new ArrayList<>();
    static int money = 1000;

    // Statyczne pola do wczytywania danych od użytkownika
    static Scanner readStringInput = new Scanner(System.in);
    static Scanner readIntInput = new Scanner(System.in);

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
                        Data.itemList.add(new HealingItem(itemName, value, sellValue, doesRecoverHP));
                        break;
                    case BATTLE:
                        damageType = DamageType.parseString(dataArray[4]);
                        Data.itemList.add(new BattleItem(itemName, value, sellValue, damageType));
                        break;
                    case WEAPON:
                        Data.itemList.add(new Weapon(itemName, value, sellValue));
                        break;
                    case HEAD:
                        secondaryValue = Integer.parseInt(dataArray[3]);
                        Data.itemList.add(new Head(itemName, value, sellValue));
                        break;
                    case BODY:
                        secondaryValue = Integer.parseInt(dataArray[3]);
                        Data.itemList.add(new Body(itemName, value, sellValue));
                        break;
                    case ACCESSORY:
                        secondaryValue = Integer.parseInt(dataArray[3]);
                        Data.itemList.add(new Accessory(itemName, value, sellValue));
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
                Data.enemyList.add(new Enemy(enemyName, hp, attack, speed, exp, money));
            }
            enemyReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
            e.printStackTrace();
        }
    }

    // Metoda zapisująca stan postaci do pliku tekstowego
    public static void saveCharacters() {
        if(Data.characters[0] == null && Data.characters[1] == null && Data.characters[2] == null && Data.characters[3] == null)
            System.out.println("Brak postaci do zapisania!");
        else{
            try {
                File saveFile = new File("src/data/save.txt");
                FileWriter saveFileWriter = new FileWriter(saveFile);
                for (int i = 0; i < Data.characters.length; i++){
                    if(Data.characters[i] == null) continue;
                    else{
                        saveFileWriter.write(Data.characters[i].saveToFile() + "\n");
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
                Data.characters[i] = new Character(characterName, hp, mp, attack, defense, magicAttack, magicDefense, speed, exp);
                i++;
            }
            saveReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
            e.printStackTrace();
        }
    }
}