package zad_6_4;

import java.util.HashMap;
import java.util.Scanner;

public class Months {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter any number from 1 to 12:");
        int number = in.nextInt();

        if(number <= 0 || number > 12){
            System.out.println("Bad number!");
            return;
        }

        System.out.println("You chose: " + number);
        System.out.println("Which month has a number " + number + "?");

        HashMap<Integer,String> months = new HashMap<>();
        months.put(1,"January");
        months.put(2,"February");
        months.put(3,"March");
        months.put(4,"April");
        months.put(5,"May");
        months.put(6,"June");
        months.put(7,"July");
        months.put(8,"August");
        months.put(9,"September");
        months.put(10,"October");
        months.put(11,"November");
        months.put(12,"December");

        System.out.println("This is " + months.get(number));
        System.out.println("All months: " + months);
    }
}