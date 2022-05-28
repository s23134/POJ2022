package zadanie_4_2;

public class Car {

    private int speed;
    protected double regularPrice;
    private String color;

    public Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public double getSalePrice(){
        return regularPrice;
    }

}