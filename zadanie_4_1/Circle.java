package zadanie_4_1;

public class Circle {

    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "blue";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "blue";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea (){
        double area = Math.PI*(this.radius * this.radius);
        return area;
    }

    @Override
    public String toString() {
        return "Circle: promień = " + getRadius() + " Pole = " + getArea();
    }
}