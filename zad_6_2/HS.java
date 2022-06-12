package zad_6_2;

import java.util.Arrays;
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

        String[] arr = new String[hashSet.size()];
        int i=0;

        for(String string : hashSet){
            arr[i++] = string;
        }

        System.out.println("Array: ");

        System.out.println(Arrays.toString(arr));
    }
}
