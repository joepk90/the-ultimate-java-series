package com.theultimatejavaseries.advanced.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {
    public static void show() {

        // example of unchecked exception
        sayHello(null);
    }

    public static void catchingExceptions() {
        try {
            var reader = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }

    // example of checked exception
    // public static void checkedException() {
    // FileNotFoundExceptionJava:
    // example of checked exception - an error which is
    // checked at compile time
    // var reader = new FileReader("file.txt");
    // }
}
