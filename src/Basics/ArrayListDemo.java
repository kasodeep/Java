package Basics;

import java.util.ArrayList;
import java.util.Collections;

/*
    It uses a dynamic array data structure to store objects and elements.
    It allows duplicate objects and elements.
    It maintains the insertion order.
    It is non-synchronized.
    Its elements/objects can be accessed randomly.
 */

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(arrayList.size());

        arrayList.add("P");
        arrayList.add("Q");
        arrayList.add("R");
        arrayList.add(1, "S");

        System.out.println("Elements of arraylist are " + arrayList);

        arrayList.remove("P");
        arrayList.remove(2);
        System.out.println(arrayList.get(4));

        Collections.reverse(arrayList);
        Collections.sort(arrayList, Collections.reverseOrder());
        Collections.swap(arrayList, 2, 4);

    }
}
