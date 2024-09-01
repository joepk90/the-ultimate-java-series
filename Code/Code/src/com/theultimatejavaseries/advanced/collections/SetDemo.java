package com.theultimatejavaseries.advanced.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void show() {
        // the order of a set is not guaranteed
        Set<String> set = new HashSet<String>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");

        System.out.println(set); // returns: [sky, blue, is]

    }
}
