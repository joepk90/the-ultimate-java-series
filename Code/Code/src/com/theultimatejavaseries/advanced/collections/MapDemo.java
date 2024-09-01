package com.theultimatejavaseries.advanced.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Map Interface:
 * - the Map interface represents a set of key value pairs.
 */

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

    public static void show() {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var customer1 = map.get("e1"); // extremely fast (O(1))
        System.out.println(customer1);

        var customer10 = map.get("e10"); // returns null
        System.out.println(customer10);

        var unknown = new Customer("Unknown", "");
        var customerDefault = map.getOrDefault("e10", unknown); // returns null
        System.out.println(customerDefault);

        var customerExists = map.containsKey("e10"); // returns bool
        System.out.println(customerExists);

        map.replace("e1", new Customer("a++", "e1")); // replaces an entry
        System.out.println(map); // returns {e1=a++, e2=b}

        // maps themeselves are not iterable, but offer methods which are...
        // for (var item : map)

        for (var key : map.keySet())
            System.out.println(key); // returns: e1, e2...

        for (var entry : map.entrySet()) {
            System.out.println(entry); // returns: e1=a, e2=b...
            System.out.println(entry.getValue()); // returns: a, b...
            System.out.println(entry.getKey()); // returns: e1, e2...
        }

        for (var customer : map.values())
            System.out.println(customer); // returns: a, b
    }
}
