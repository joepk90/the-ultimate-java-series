package com.theultimatejavaseries.advanced.collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ListDemo {
    public static void show() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(0, "!"); // adds list item at first index
        System.out.println(list);

        list.clear();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list.get(0));

        list.set(0, "a+");
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        list.clear();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list.indexOf("a")); // returns index of first occurance of a = 0
        System.out.println(list.indexOf("a+")); // if the value does not exist, -1 is returned

        list.add("a");
        System.out.println(list.lastIndexOf("a")); // returns 3

        // returns items from index 0 up to index 2
        System.out.println(list.subList(0, 2)); // returns [a, b]

    }
}
