package com.theultimatejavaseries.advanced.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.theultimatejavaseries.advanced.generics.GenericList;

public class Main {
    public static void main(String[] args) {
        // theNeedForIterables();
        // iterab leInterface();
        // collectionInterface();
        // listInterface();
        comparableInterface();

    }

    public static void theNeedForIterables() {
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");

        // unable to iterate over the list without exposing the items property on the
        // GenericList class
        // for (var item : list.items)
        // System.out.println(item);
    }

    public static void iterableInterface() {
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");

        var iterator = list.iterator();
        while (iterator.hasNext()) {
            // [a, b, c]
            /// ^

            var current = iterator.next();
            System.out.println(current);
        }

        // foreach loop actually uses the iterator methods above (see bytecode)
        // foreach loop is actually just syntaxible sugar for iterator methods
        for (var item : list) {
            System.out.println(item);
        }
    }

    public static void collectionInterface() {
        CollectionsDemo.show();
    }

    public static void listInterface() {
        ListDemo.show();
    }

    public static void comparableInterface() {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("a"));
        customers.add(new Customer("b"));
        customers.add(new Customer("c"));

        Collections.sort(customers);
        System.out.println(customers); // [a, b, c]
    }
}
