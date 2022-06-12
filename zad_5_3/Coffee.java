package zad_5_3;

import java.util.ArrayList;
import java.util.Iterator;

public class Coffee {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("espresso");
        arrayList.add("latte");
        arrayList.add("cappuccino");
        arrayList.add("mocha");
        arrayList.add("auLait");
        arrayList.add("macchiato");

        System.out.println(arrayList);

        Iterator<String> itr = arrayList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        for(String string : arrayList){
            System.out.println(string.toUpperCase());
        }

        for(int i = 0; i<arrayList.size();i++){
            System.out.println(arrayList.get(i).substring(0,4));
        }
    }
}
