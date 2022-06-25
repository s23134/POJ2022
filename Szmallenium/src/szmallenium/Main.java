package szmallenium;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager(); // Tworzy 'Managera' który posiada wszytkie metody związane z logiką biznesową
        manager.initializationData(); // Inicjalizuje jakieś dane na początek programu, żeby nie trzeba było wprowadzać za każdym razem

        System.out.println("--Oprogramowanie dla banku Szmallenium--".toUpperCase()); // Drukuje tytuł programu
        int choice = -1; // zmienna która przechowuje wybór użytkownika

        // To "\033[0;33m" oznacza kolor wyświetlanego stringa, w tym wypadku żółty, a to "\u001B[0m" resetuje kolor na biała
        System.out.println("\033[0;33m" + "***********************************************" + "\u001B[0m");
        System.out.println("Dane które zostały dodane na początku programu:");
        manager.displayAllAtms();
        manager.displayAllCards();
        System.out.println("\033[0;33m" + "***********************************************" + "\u001B[0m");

        // Pętla która wykonuję się dopóki użytkownik nie wprowadzi '0'
        while (choice != 0) {
            printMenu(); // Wyświetla menu (metoda poniżej)
            choice = getUserChoice(); // Pobiera wybór użytkownika
            switch (choice) { // Wywołuje metodę która znajduję się pod danym wyborem
                case 0 -> {
                }
                case 1 -> manager.addAtm();
                case 2 -> manager.removeAtm();
                case 3 -> manager.displayAllAtms();
                case 4 -> manager.addCard();
                case 5 -> manager.removeCard();
                case 6 -> manager.displayAllCards();
                case 7 -> manager.withdrawFromCard();
                case 8 -> manager.depositToCard();
                case 9 -> manager.depositToAtm();
            }
            if (choice < 0 || choice > 9)
                System.out.println("*** Wpisz numer między 0, a 9 ***");
        }
    }

    // Drukuje menu
    public static void printMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("[1] Dadaj bankomat.");
        System.out.println("[2] Usuń bankomat.");
        System.out.println("[3] Wyświetl wszytkie bankomaty.");
        System.out.println("[4] Dodaj kartę płatniczą.");
        System.out.println("[5] Usuń kartę płatnicze.");
        System.out.println("[6] Wyświetl wszystkie karty płatnicze.");
        System.out.println("[7] Wypłać.");
        System.out.println("[8] Wpłać.");
        System.out.println("[9] Uzupełnij bankomat.");
        System.out.println("[0] ZAMKNIJ.");
        System.out.println("========================================");
    }

    // Pobiera wybór użytkownika
    public static int getUserChoice() {
        System.out.print("Wpisz wybór [numer opcji]: ");
        return new Scanner(System.in).nextInt();
    }
}