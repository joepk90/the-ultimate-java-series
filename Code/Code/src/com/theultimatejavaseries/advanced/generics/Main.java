package com.theultimatejavaseries.advanced.generics;

import java.lang.Integer;

public class Main {
    public static void main(String[] args) {
        // basics();
        // contraints();
        // comparableInterface();
        // genericMethods();
        // multipleTypeParameters();
        genericClassesAndInheritance();
    }

    public static void basics() {
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

        // var userList = new GenericList<User>();
        // userList.add(new User());
        // User user = userList.get(0);

        // Generics only accepts reference types, not primative types
        // the following won't work:
        // new GenericList<int>();
        // new GenericList<short>();
        // new GenericList<boolean>();
        // new GenericList<gloat>();

        // in order to use a primative values inside a class using geenrics,
        // we have to the wrapper class.
        //
        // Every Primative Type in Java has a wrapper class:
        // int -> Integer
        // float -> Float
        // boolean -> Boolean

        GenericList<Integer> numbers = new GenericList<>();
        numbers.add(1); // Boxing: Integer.valueOf(1)
        int primativeNumber = numbers.get(0); // Unboxing
    }

    public static void contraints() {
        // compilation error, because String does not inherit from a Number:
        // https://docs.oracle.com/javase/8/docs/api/java/lang/Number.html
        // var userList = new GenericList<String>();

        // only classes that derive from the Number class can be used
        // new GenericList<Number>();
        new GenericList<Integer>();
        new GenericList<Float>();

        // only classes that are comparable can be used
        new GenericList<Short>();
        new GenericList<Integer>();
        new GenericList<String>();
        new GenericList<User>();

    }

    public static void comparableInterface() {
        var user1 = new User(10);
        var user2 = new User(20);

        // the following expression is not possible
        // if (user1 < user1)

        // coomparable interator required
        if (user1.compareTo(user2) < 0)
            System.out.println("user1 < user2");
        else if (user1.compareTo(user2) == 0)
            System.out.println("user1 == user2");
        else
            System.out.println("user1 > user2");
    }

    public static void genericMethods() {
        var max = Utils.max(1, 3);
        System.out.println(max);

        var userMax = Utils.max(new User(10), new User(20));
        System.out.println(userMax);
    }

    public static void multipleTypeParameters() {
        Utils.print(1, 10);
    }

    public static void genericClassesAndInheritance() {
        Utils.printUser(new Instructor(10));

        // Compilation Error Caused:
        // - Under the hood in byte code we are dealing with a single class
        // - A generic list of Instructor is not a sub type of Generic List of User
        var instructors = new GenericList<Instructor>();

        // one solution - convert instructors list to users list (sudo code)
        // var users = new GenericList<User>();
        // for (Instructor i : instructors) users.add(instructors[i])
        // Utils.printUsers(users);

        Utils.printUsers(instructors);
    }
}
