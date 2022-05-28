package zadanie_3_1;

public class Circle {

    private double radius;
    private String color;

    public Circle() {
        this.radius = 2;
        this.color = "Zielony";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "Zielony";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea (){
        double area = Math.PI*(this.radius * this.radius);
        return area;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle: promień = " + getRadius() + " Pole = " + getArea();
    }
}