package com.theultimatejavaseries.advanced.collections;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void hashMapDocumentation() {
        List<Customer> customers = new ArrayList<Customer>();

        // not a scalable algorythm - iterating the entire list is required
        // O(n): if 10 items are in the list, then O(10)
        for (var customer : customers) {
            if (customer.getEmail() == "e1")
                System.out.println("Found");
        }

        // HashTables solve this problem
        // - a hash table uses special data structure
        // - a hash table reduces the O(n) of the above operation to O(1)
        // ---
        // Java: Maps (HashMaps)
        // C#: Dictonary
        // Python: Dictonary
        // javascript: Object
    }
}
