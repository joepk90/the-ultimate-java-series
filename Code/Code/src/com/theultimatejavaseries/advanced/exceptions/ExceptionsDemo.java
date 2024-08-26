package com.theultimatejavaseries.advanced.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo {
    public static void show() {

        // example of unchecked exception
        sayHello(null);
    }

    public static void catchingExceptions() {
        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.out.println("File does not exist.");

            // because IOException is more generic, it must come after the
            // FileNotFoundException catch block
            // otherwise the FileNotFoundException catch block can never be reached
        } catch (IOException e) {
            IOException ex = new FileNotFoundException();
            System.out.println("Could not read data.");
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
