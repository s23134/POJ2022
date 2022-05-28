package zadanie_4_2;

public class Truck extends Car implements Purchase{

    private int weight;

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if (weight > 2000){
            return regularPrice *0.9;
        }
        else {
            return super.getSalePrice();
        }
    }

    @Override
    public String getPurchaseInfo() {
        return "TRUCK";
    }
}