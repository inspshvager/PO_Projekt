import java.io.IOException;

public class Run {
    // Metoda rozpoczynająca gre
    public static void runMain() throws IOException {
        // Wczytanie danych z plików
        Data.readEnemies();
        Data.readItems();

        // Menu startowe - Nowa gra, kontynuacja, pomoc, itd.
        Menu.startMenu();

        // Menu główne gry
        Menu.mainMenu();
    }
}