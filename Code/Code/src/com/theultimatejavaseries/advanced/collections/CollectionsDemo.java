package com.theultimatejavaseries.advanced.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<String>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.remove("a");
        collection.clear();

        Collections.addAll(collection, "a", "b", "c");
        var containsA = collection.contains("a");
        System.out.println(containsA);
        Object[] objectArray = collection.toArray();
        var stringArray = collection.toArray(new String[0]);
        stringArray[0].toUpperCase();

        for (var item : collection) {
            System.out.println(item);
        }

        System.out.println(collection);
        System.out.println(collection.size());

        Collection<String> other = new ArrayList<String>();
        other.addAll(collection);

        System.out.println(collection == other); // false
        System.out.println(collection.equals(other)); // true
    }
}
