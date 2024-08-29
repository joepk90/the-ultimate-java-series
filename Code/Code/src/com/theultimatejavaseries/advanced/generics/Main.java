package com.theultimatejavaseries.advanced.generics;

public class Main {
    public static void main(String[] args) {
        var list = new List();
        list.add(1); // java compiler will convert this value to Integer.valueOf(1)
        list.add("1");
        list.add(new User());

        int number = (int) list.get(0);
        // this causes an error because the second
        // item added is a string ("1")
        // int number = (int) list.get(1);

        // using the Object type for our List, means we are unable to catch type casting
        // bugs like this at compile time.
    }
}
