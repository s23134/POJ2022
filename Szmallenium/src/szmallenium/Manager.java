package szmallenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

    // Lista przechowuje wszystkie bankomaty
    public static List<ATM> atms = new ArrayList<>();

    // Lista przechowuje wszystkie karty
    public static List<Card> cards = new ArrayList<>();

    // Dodawanie bankomatu
    public void addAtm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Tworzenie bankomatu--");
        System.out.println("Nazwa bankomatu: ");
        String atmName = scanner.next(); // Pobiera nazwę bankomatu z klawiatury
        ATM atm = new ATM(atmName); // Tworzy nowy bankomat z podaną nazwą
        atms.add(atm); // Dodaje nowy bankomat do listy bankomatów
        System.out.println("Stworzono bankomat o nazwie: " + atm.getAtmName());
    }

    // Usuwanie bankomatu
    public void removeAtm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Usuwanie bankomtu--");
        displayAllAtms(); // Wyświetla wszystkie bankomaty
        System.out.println("ID bankomatu: ");
        int atmId = scanner.nextInt(); // Pobiera ID bankomatu
        if (atmId >= 0 && atmId < atms.size()) { // Sprawdza czy ID bankomatu jest poprawne (czy należy do listy)
            atms.remove(atmId); // Usuwa bankomat z listy
            System.out.println("Usunięto bankomat o ID: " + atmId);
        } else {
            System.out.println("Nie znaleniono banku o ID: " + atmId);
        }
    }

    // Wyświetlanie wszystkich bankomatów
    public void displayAllAtms() {
        System.out.println("Lista bankomatów:");
        for (int i = 0; i < atms.size(); i++) { // Iteruje po całej liście bankomatów i wyświetla informacje o nim
            System.out.println("ID: " + i + "\n\t" + atms.get(i).toString());
        }
    }

    // Dodawanie karty
    public void addCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Tworzenie karty płatniczej--");
        System.out.println("Imię posiadacza karty: ");
        String ownerName = scanner.next(); // Pobiera imię użytkownika karty z klawiatury
        String pinNumber;
        do { // Wykonuję się dopuki użytkownik nie wprowadzi poprawnego PINu
            System.out.println("PIN karty: ");
            pinNumber = scanner.next(); // Pobira PIN z klawiatury
            if (!pinValidator(pinNumber)) { // Sprawdza czy PIN jest poprawny -> pinValidator() -> musi mieć 4 cyfry
                System.out.println("PIN musi zawierać 4 cyfry!");
            }
        } while (!pinValidator(pinNumber));
        Card card = new Card(ownerName, pinNumber); // Tworzy nową kartę
        cards.add(card); // Dodaje katę do listy kart
        System.out.println("Generowanie numeru karty...");
        System.out.println("Stworzono kartę o numerze: " + card.getCardNumber());
    }

    // Usuwanie karty
    public void removeCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Usuwanie karty płatniczej--");
        displayAllCards(); // Wyświetla wszystkie karty
        System.out.println("ID karty: ");
        int cardID = scanner.nextInt(); // Pobiera ID karty z klawiatury
        if (cardID >= 0 && cardID < cards.size()) { // Sprawdza czy ID znajduję się na liście
            cards.remove(cardID); // Usuwa kartę z listy kart
            System.out.println("Usunięto kartę o ID: " + cardID);
        } else {
            System.out.println("Nie znaleniono karty o ID: " + cardID);
        }
    }

    // Wyświetlanie wszystkich kart płatniczych
    public void displayAllCards() {
        System.out.println("Lista kart płatniczych:");
        for (int i = 0; i < cards.size(); i++) { // Iteruje po wszystkich kartach i wyświetla informacje o każdej z nich
            System.out.println("ID: " + i + "\n\t" + cards.get(i).toString());
        }
    }

    // Wypłacanie z karty
    public void withdrawFromCard() {
        System.out.println("--Wypłata pieniędzy--");
        Scanner scanner = new Scanner(System.in);
        displayAllAtms();

        ATM atm = null;
        int atmId;
        do {
            System.out.println("Podaj ID bankomatu:");
            atmId = scanner.nextInt();
            if (atmId < 0 || atmId > atms.size()) {
                System.out.println("Nie ma bankomatu o podanym ID.");
            } else {
                if (atms.get(atmId).getAmountOfMoney() == 0) {
                    System.out.println("W bankomacie nie ma gotówki! Spróbuj inny lub uzupełni!");
                    return;
                }
                atm = atms.get(atmId);
            }
        } while (atmId < 0 || atmId > atms.size());
        System.out.println("Wybrano bankomat: " + atm.getAtmName());

        Card card;
        System.out.println("Podaj numer karty: ");
        long cardNumber = scanner.nextLong();
        card = findCardByNumber(cardNumber);
        if (card == null) {
            System.out.println("Nie znaleziono karty o tym numerze! Spróbuj ponownie!");
            return;
        } else if (card.isLocked()) {
            System.out.println("Karta jest zablokowana!");
            return;
        } else {
            System.out.println("Wybrano kartę o numerze: " + card.getCardNumber());
        }

        byte tries = 3;
        String pin;
        do {
            System.out.println("Podaj PIN: ");
            pin = scanner.next();
            if (card.getPin().equals(pin)) {
                System.out.println("Poprawny PIN.");
            } else {
                tries--;
                System.out.println("Zły PIN! Masz jeszcze " + tries + " szanse!");
            }
            if (tries == 0) {
                System.out.println("Za dużo złych prób! Karta zblokowana!");
                card.setLocked(true);
            }
        } while (tries != 0 && !card.getPin().equals(pin));

        int amountToWithdraw;
        do {
            System.out.println("Ile wypłacić (w bankomacie jest " + atm.getAmountOfMoney() + " zł): ");
            amountToWithdraw = scanner.nextInt();
            if (atm.getAmountOfMoney() >= amountToWithdraw) {
                card.withdraw(amountToWithdraw);
                atm.setAmountOfMoney(atm.getAmountOfMoney() - amountToWithdraw);
                return;
            } else {
                System.out.println("W bankomacie jest za mało pieniędzy! Spróbuj ponownie inną kwotę!");
            }
        } while (amountToWithdraw >= atm.getAmountOfMoney());
    }

    // Wpłacanie na kartę
    public void depositToCard() {
        System.out.println("--Wpłać na karte--");
        Scanner scanner = new Scanner(System.in);
        displayAllCards();

        Card card;
        System.out.println("Podaj numer karty na którą wpłacić: ");
        long cardNumber = scanner.nextLong();
        card = findCardByNumber(cardNumber);
        if (card == null) {
            System.out.println("Nie znaleziono karty o tym numerze! Spróbuj ponownie!");
        } else if (card.isLocked()) {
            System.out.println("Karta jest zablokowana!");
        } else {
            System.out.println("Wybrano kartę o numerze: " + card.getCardNumber());
            System.out.println("Ile Wpłacić na kartę: ");
            long amountToDeposit = scanner.nextLong();
            if (amountToDeposit < 0) {
                System.out.println("Ilość nie może być mniejsza od 0!");
                return;
            }
            card.deposit(amountToDeposit);
        }
    }

    // Uzupełnianie bankomatu
    public void depositToAtm() {
        System.out.println("--Uzupełni bankomat--");
        List<ATM> atmsToRefill = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < atms.size(); i++) {
            if (atms.get(i).getAmountOfMoney() == 0) {
                atmsToRefill.add(atms.get(i));
            }
        }
        if (atmsToRefill.size() == 0) {
            System.out.println("Niema bankomatów które potrzebują gotówki.");
            return;
        } else {
            System.out.println("Bankomaty do uzupełnienia:");
        }
        for (int i = 0; i < atmsToRefill.size(); i++) {
            System.out.println("ID: " + i + "\n\t" + atmsToRefill.get(i).toString());
        }

        ATM atm;
        int atmIdToRefill;
        do {
            System.out.println("Podaj ID bankomatu do uzupełnienia:");
            atmIdToRefill = scanner.nextInt();
            if (atmIdToRefill < 0 || atmIdToRefill > atmsToRefill.size()) {
                System.out.println("Nie ma bankomatu o podanym ID na liście bankomatów do uzupełnienia.");
            } else {
                atm = atmsToRefill.get(atmIdToRefill);
                int amountToRefill;
                System.out.println("O ile uzupełnić (zł): ");
                amountToRefill = scanner.nextInt();
                if (amountToRefill < 0) {
                    System.out.println("Ilość nie może być mniejsza od 0!");
                    return;
                }
                atm.setAmountOfMoney(atm.getAmountOfMoney() + amountToRefill);
                System.out.println("Dodano " + amountToRefill + " zł do bankomatu: " + atm.getAtmName());
            }
        } while (atmIdToRefill < 0 || atmIdToRefill > atms.size());
    }

    // Walidacja numeru PIN
    private boolean pinValidator(String pinCode) {
        String regex = "^\\d{4}$"; // Wyrażenie regularne (musi mieć 4 cyfry)
        Pattern p = Pattern.compile(regex);
        if (pinCode == null) {
            return false;
        }
        Matcher m = p.matcher(pinCode); // Sprawdzenie czy podany PIN pasuje do wzoru (czyli 4 cyfry)
        return m.matches();
    }

    // Zanalezienie karty po numerze z listy kart
    private Card findCardByNumber(long cardNumber) {
        for (Card card : cards) {
            if (cardNumber == card.getCardNumber()) {
                return card;
            }
        }
        return null;
    }

    // Dodanie przykładowych danych na początek programu, żeby nie trzeba było dodawać za każdym razem
    public void initializationData() {
        atms.add(new ATM("Bankomat1"));
        atms.add(new ATM("Bankomat2"));
        cards.add(new Card("Adam", "1111"));
        cards.add(new Card("Robert", "1234"));
    }
}