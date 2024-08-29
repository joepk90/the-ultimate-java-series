package com.theultimatejavaseries.advanced.generics;

import java.lang.Integer;

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

        // using Generics with the GenericList:
        var integerList = new GenericList<Integer>();
        integerList.add(1);
        int integerNumber = integerList.get(0);

        var userList = new GenericList<User>();
        userList.add(new User());
        User user = userList.get(0);
    }
}
