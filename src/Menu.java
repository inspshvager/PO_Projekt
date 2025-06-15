import java.io.IOException;
import java.util.Random;

public class Menu {
    // Metoda uruchamiająca menu startowe
    public static void startMenu() throws IOException {
        System.out.println("Witaj w konsolowej grze RPG!");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1. Nowa gra\n2. Wczytaj grę\n3. Pomoc\n4. Wyjście.");
        UserOperations.input = Data.readStringInput.nextLine();
        if(UserOperations.isDigits(UserOperations.input)){
            switch (Integer.parseInt(UserOperations.input)){
                case 1:
                    newGame();
                    break;
                case 2:
                    Data.loadCharacters();
                    break;
                case 3:
                    helpMenu();
                    break;
                default:
                    System.exit(0);
            }
        }
        else{
            System.out.println("Niepoprawne dane!");
            startMenu();
        }
    }

    // Metoda rozpoczynająca nową grę
    public static void newGame(){
        System.out.println("Stwórz 4 postacie:");
        Data.characters[0] = UserOperations.createCharacter();
        Data.characters[1] = UserOperations.createCharacter();
        Data.characters[2] = UserOperations.createCharacter();
        Data.characters[3] = UserOperations.createCharacter();
        for (Character x : Data.characters){
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
            UserOperations.input = Data.readStringInput.nextLine();
            if (UserOperations.isDigits(UserOperations.input)){
                switch (Integer.parseInt(UserOperations.input)) {
                    case 1:
                        //battle();
                    case 2:
                        teamStatus();
                        break;
                    case 3:
                        shop();
                        break;
                    case 4:
                        Data.saveCharacters();
                        break;
                    case 5:
                        System.exit(0);
                }
            }
            else{
                System.out.println("Błędne dane!");
            }
        }
    }

    // Metoda do obsługi drużyny
    public static void teamStatus(){
        System.out.println("Wybierz członka drużyny:");
        int i;
        for (i = 0; i < Data.characters.length; i++){
            if(Data.characters[i] == null) continue;
            else{
                System.out.println((i+1) + ". " + Data.characters[i].getName());
            }
        }
        UserOperations.input = Data.readStringInput.nextLine();
        if (UserOperations.isDigits(UserOperations.input)){
            switch (Integer.parseInt(UserOperations.input)){
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
        }
        else {
            System.out.println("Niepoprawne dane!");
            return;
        }
        UserOperations.readCharacter(Data.characters[i]);
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1. Wyposarzenie\n2. Edycja\n3. Usuń\n4. Wyjście");
        UserOperations.input = Data.readStringInput.nextLine();
        if (UserOperations.isDigits(UserOperations.input)){
            switch (Integer.parseInt(UserOperations.input)){
                case 1:
                    if(Data.inventory.isEmpty()){
                        System.out.println("Brak przedmiotów do wyposarzenia!");
                    }
                    else{
                        for (int j = 0; j < Data.inventory.size(); j++){
                            System.out.println((j+1) + ". " + Data.inventory.get(j).getName());
                        }
                        System.out.println("Wybierz przedmiot:");
                        int choice = Data.readIntInput.nextInt();
                        if (Data.inventory.get(choice-1) instanceof Weapon || Data.inventory.get(choice-1) instanceof Head ||
                                Data.inventory.get(choice-1) instanceof Body || Data.inventory.get(choice-1) instanceof Accessory){
                            ((Equip) Data.inventory.get(choice-1)).equip(Data.characters[i]);
                            System.out.println("Wyposarzono przedmiot!");
                        }
                    }
                    break;
                case 2:
                    UserOperations.updateCharacter(Data.characters[i]);
                case 3:
                    UserOperations.deleteCharacter();
                default:
                    break;
            }
        }
        else{
            System.out.println("Niepoprawne dane!");
        }
    }

    // Metoda do obsługi sklepu
    public static void shop(){
        Random random = new Random();
        AItem[] shopItems = new AItem[6];
        for (int i = 0; i < 6; i++) {
            shopItems[i] = Data.itemList.get(random.nextInt(Data.itemList.size()));
        }
        System.out.println("Witaj w sklepie!");
        System.out.println("Mam do zaoferowania dziś takie oto przedmioty!");
        for (int i = 0; i < 6; i++) {
            System.out.println((i+1) + ". " + shopItems[i].getName() + ", $" + shopItems[i].getSellValue());
        }
        UserOperations.input = Data.readStringInput.nextLine();
        if (UserOperations.isDigits(UserOperations.input)){
            switch (Integer.parseInt(UserOperations.input)) {
                case 1:
                    if(Data.money >= shopItems[0].getSellValue()){
                        Data.money -= shopItems[0].getSellValue();
                        Data.inventory.add(shopItems[0]);
                        System.out.println("Dziękuje, zapraszam ponownie!");
                    }
                    else{
                        System.out.println("Brak wystarczająco pieniędzy!");
                    }
                    break;
                case 2:
                    if(Data.money >= shopItems[1].getSellValue()){
                        Data.money -= shopItems[1].getSellValue();
                        Data.inventory.add(shopItems[1]);
                        System.out.println("Dziękuje, zapraszam ponownie!");
                    }
                    else{
                        System.out.println("Brak wystarczająco pieniędzy!");
                    }
                    break;
                case 3:
                    if(Data.money >= shopItems[2].getSellValue()){
                        Data.money -= shopItems[2].getSellValue();
                        Data.inventory.add(shopItems[2]);
                        System.out.println("Dziękuje, zapraszam ponownie!");
                    }
                    else{
                        System.out.println("Brak wystarczająco pieniędzy!");
                    }
                    break;
                case 4:
                    if(Data.money >= shopItems[3].getSellValue()){
                        Data.money -= shopItems[3].getSellValue();
                        Data.inventory.add(shopItems[3]);
                        System.out.println("Dziękuje, zapraszam ponownie!");
                    }
                    else{
                        System.out.println("Brak wystarczająco pieniędzy!");
                    }
                    break;
                case 5:
                    if(Data.money >= shopItems[4].getSellValue()){
                        Data.money -= shopItems[4].getSellValue();
                        Data.inventory.add(shopItems[4]);
                        System.out.println("Dziękuje, zapraszam ponownie!");
                    }
                    else{
                        System.out.println("Brak wystarczająco pieniędzy!");
                    }
                    break;
                case 6:
                    if(Data.money >= shopItems[5].getSellValue()){
                        Data.money -= shopItems[5].getSellValue();
                        Data.inventory.add(shopItems[5]);
                        System.out.println("Dziękuje, zapraszam ponownie!");
                    }
                    else{
                        System.out.println("Brak wystarczająco pieniędzy!");
                    }
                    break;
                default:
                    System.out.println("Nie mam takiego przedmiotu!");
                    break;
            }
        }
        else{
            System.out.println("Nie poprawne dane!");
        }
    }
}