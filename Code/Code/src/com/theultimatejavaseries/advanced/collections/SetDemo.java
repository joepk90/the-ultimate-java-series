package com.theultimatejavaseries.advanced.collections;

import java.util.HashSet;
// import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Set Interface:
 * - the Set interface represents a unique list of values.
 */

public class SetDemo {
    public static void show() {
        // the order of a set is not guaranteed
        Set<String> set = new HashSet<String>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");

        System.out.println(set); // returns: [sky, blue, is]

        Collection<String> collection = new ArrayList<String>();
        Collections.addAll(collection, "a", "b", "c", "c");
        Set<String> collectionSet = new HashSet<String>(collection);

        // passing a Collection with duplicates to a Set, will remove duplicates
        System.out.println(collectionSet); // returns: [a, b, c]

        // List<String> list = new ArrayList<String>() - alternatively use Arrays.asList
        Set<String> set1 = new HashSet<String>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<String>(Arrays.asList("b", "c", "d"));

        // Union: combination of two sets (two sets without duplicates)
        // set1.addAll(set2);
        // System.out.println(set1); // returns: [a, b, c, d]

        // Intersection: returns items which are common across multiple sets
        // set1.retainAll(set2);
        // System.out.println(set1); // returns: [b, c]

        // Difference: returns items which don't exist in the second set
        set1.removeAll(set2);
        System.out.println(set1); // returns: [b, c]

    }
}
