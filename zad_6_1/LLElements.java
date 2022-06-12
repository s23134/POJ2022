package zad_6_1;

import java.util.LinkedList;

public class LLElements {
    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Red");
        linkedList.add("Green");
        linkedList.add("Black");
        linkedList.add("Pink");
        linkedList.add("Orange");

        System.out.println("The Original linked list: " + linkedList);
        System.out.println("Element removed: " + linkedList.removeFirst());
        System.out.println("Element removed: " + linkedList.removeLast());
        System.out.println("The New linked list: " + linkedList);
    }
}