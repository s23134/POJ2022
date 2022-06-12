package zad_6_3;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TS {
    public static void main(String[] args) {

        TreeSet<String> tree1 = new TreeSet<>();
        tree1.add("Red");
        tree1.add("Green");
        tree1.add("Black");
        tree1.add("Pink");
        tree1.add("Orange");
        System.out.println("a)");

        System.out.println("Tree1: " + tree1);

        System.out.println("b)");
        for (String string : tree1){
            System.out.println(string);
        }

        TreeSet<String> tree2 = new TreeSet<>();
        tree2.add("Red");
        tree2.add("Green");
        tree2.add("White");
        System.out.println("c)");
        System.out.println("Tree2: " + tree2);

        tree1.addAll(tree2);
        System.out.println("Tree1 + Tree2: " + tree1);

        System.out.println("d)");

        NavigableSet<String> treeReverse = tree1.descendingSet();
        System.out.println("Tree1 reverse: " + treeReverse);

        System.out.println("e)");
        System.out.println("First element in tree1: " + tree1.first());
        System.out.println("Last element in tree1: " + tree1.last());


        TreeSet<String> tree3 = (TreeSet<String>) tree1.clone();
        System.out.println("f)");
        System.out.println("Tree3: " + tree3);

        System.out.println("g)");
        System.out.println("Tree3 size: " + tree3.size());

        System.out.println("h)");
        System.out.print("Tree1 contains from Tree2: ");
        for(String s1 : tree1){
            for (String s2 : tree2){
                if(s1.equals(s2)){
                    System.out.print(s2 + " ");
                }
            }
        }
    }
}