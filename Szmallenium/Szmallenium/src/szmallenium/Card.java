package szmallenium;

import java.util.Random;

// Klasa reprezentująca kartę płatniczą
public class Card {

    private long cardNumber; // Jakiś numer karty
    private String owner; // Jakiś posiadacz
    private String pin; // Jakiś PIN
    private long balance; // Stan konta
    private boolean isLocked; // Czy jest zablokowana

    // Konstruktor z wszystkimi argumentami
    public Card(String owner, String pin) {
        this.cardNumber = generateCardNumber(); // ustawia na losowy numer karty przy tworzeniu
        this.owner = owner;
        this.pin = pin;
        this.balance = 10000L; // ustawia na początek ilość pieniędzy n koncie na 10 000
        this.isLocked = false; // ustawia na początek na false (karta nie jest zablokowana)
    }

    // Gettery i settery
    public long getCardNumber() {
        return cardNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    // Generuje losowy numer karty
    private long generateCardNumber() {
        Random random = new Random();
        long toReturn;
        do {
            toReturn = random.nextLong();
        } while (toReturn <= 1000000000000000L || toReturn >= 9999999999999999L);
        return toReturn;
    }

    // Metoda do wypłacania z karty
    public void withdraw(long amountToWithdraw) {
        // Sprawdzenie czy jest wystarczająca ilość pieniędzy na koncie
        if (amountToWithdraw > getBalance()) {
            System.out.println("Za mały stan konta!");
        } else {
            setBalance(getBalance() - amountToWithdraw); // Ustwienie aktualnego stanu na nowy pomniejszony o ilość wypłacanych pieniędzy
            System.out.println("Wypłacono " + amountToWithdraw + " zł.");
            System.out.println("Aktualny stan konta: " + getBalance() + " zł.");
        }
    }

    // Metoda do wpłacania
    public void deposit(long amountToDeposit) {
        setBalance(getBalance() + amountToDeposit);
        System.out.println("Wpłacono " + amountToDeposit + " zł.");
        System.out.println("Aktualny stan konta: " + getBalance() + " zł.");
    }

    // Nadpisana metoda toString() -> tekstowa reprezentacja objektu klasy
    @Override
    public String toString() {
        return "Informacje o karcie:\n" +
                "\tNumer karty -> " + getCardNumber() + "\n" +
                "\tWłaściciel karty -> " + getOwner() + "\n" +
                "\tPIN karty -> " + getPin() + "\n" +
                "\tStan konta -> " + getBalance() + " zł\n" +
                "\tZablokowana -> " + isLocked();
    }
}