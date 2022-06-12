package zad_5_1;

import java.util.ArrayList;
import java.util.Date;

public class EvenNumbers {
    public static void main(String[] args) {

        Date d0 = new Date();

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            integers.add(i * 2);
        }

        for (int i = 0; i < 50; i++) {
            System.out.println("Index: " + i + " value: " + integers.get(i));
        }

        Date d1 = new Date();
        System.out.println("Operation time: " + (d1.getTime()-d0.getTime()) + " [ms]");
    }
}