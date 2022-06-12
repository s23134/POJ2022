package zad_6_2;

import java.util.HashSet;

public class HS {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();

        System.out.println("HashSet: ");
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Black");
        hashSet.add("Pink");
        hashSet.add("Orange");

        System.out.println(hashSet);

        System.out.println("Array: ");
        Object [] tablica = hashSet.toArray();
        for(int i = 0 ; i < tablica.length ; i++){
            System.out.println(tablica[i]);
        }

    }
}
