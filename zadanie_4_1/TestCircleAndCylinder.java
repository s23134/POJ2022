package zadanie_4_1;

public class TestCircleAndCylinder {

    public static void main(String[] args) {

        Circle circle = new Circle();

        System.out.println(circle);

        Circle circle2 = new Circle(5);

        System.out.println( circle2);

        System.out.println("Circle 2: PROMIEN = " + circle2.getRadius() + " POLE = " + circle2.getArea()  );

        Cylinder cylinder = new Cylinder();

        System.out.println(cylinder);

        Cylinder cylinder2 = new Cylinder(5);

        System.out.println(cylinder2);

        Cylinder cylinder3 = new Cylinder(5, 10);

        System.out.println(cylinder3);

        System.out.println("Circle 2: PROMIEN = " + circle2.getRadius() + " POLE = " + circle2.getArea() + " WYSOKOŚĆ = " + cylinder3.getHeight() + " OBJETOŚĆ = " + cylinder3.getVolume()  );
    }
}