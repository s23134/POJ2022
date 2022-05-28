package zadanie_4_1;

public class Cylinder extends Circle {

    private double height;

    public Cylinder() {
        this.height = 4.0;
    }

    public Cylinder(double radius) {
        super(radius);
        this.height = 4.0;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume (){
        double volume = getArea() * height;
        return volume;
    }

    @Override
    public String toString() {
        return "Cylinder: promień = " + getRadius() + " Pole = " + getArea() +  " Wysokość = " + height + " Objętość = " + getVolume();
    }
}