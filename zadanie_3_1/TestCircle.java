package zadanie_3_1;

public class TestCircle {

    public static void main(String[] args) {

        Circle circle = new Circle();
        Circle circle2 = new Circle(5);
        Circle circle3  = new Circle(6, "Niebieski");

        Circle circle4  = new Circle();


        circle4.setColor("Biały");
        circle4.setRadius(7);


        System.out.println("\nObiekt 1: circle ma Promień = " + circle.getRadius() + " ,Pole = " + circle.getArea());

        System.out.println(circle);

        System.out.println("\nObiekt 2: circle2 ma Promień = " + circle2.getRadius() + " ,Pole = " + circle2.getArea());
        System.out.println(circle2);

        System.out.println("\nObiekt 3: circle3 ma Promień = " + circle3.getRadius() + " ,Pole = " + circle3.getArea());
        System.out.println(circle3);

        System.out.println("\nObiekt 4: circle4 ma Promień = " + circle4.getRadius() + " ,Pole = " + circle4.getArea());
        System.out.println(circle4);

    }
}