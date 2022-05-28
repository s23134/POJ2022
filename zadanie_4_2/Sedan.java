package zadanie_4_2;

public class Sedan  extends Car implements Purchase{

    private int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        if ( length > 20){
            return regularPrice * 0.95;
        }
        else {
            return regularPrice * 0.9;
        }
    }

    @Override
    public String getPurchaseInfo() {
        return "SEDAN";
    }
}