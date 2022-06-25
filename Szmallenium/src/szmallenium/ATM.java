package szmallenium;

public class ATM {

    private String atmName; // Jakaś nazwa bankomatu
    private long amountOfMoney;

    // Konstruktor z wszystkimi argumentami
    public ATM(String atmName) {
        this.atmName = atmName;
        this.amountOfMoney = 10000L;
    }

    // Gettery i settery dla każdego pola
    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    // Nadpisana metoda toString() -> tekstowa reprezentacja objektu klasy
    @Override
    public String toString() {
        return "Inforamcje o bankomacie:\n" +
                "\tNazwa -> " + atmName + "\n" +
                "\tIlość pieniędzy w bankomacie -> " + amountOfMoney + " zł";
    }
}
