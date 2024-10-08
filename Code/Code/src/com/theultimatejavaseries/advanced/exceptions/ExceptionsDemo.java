package com.theultimatejavaseries.advanced.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
// import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() {

        // example of unchecked exception
        sayHello(null);
    }

    public static void catchingExceptions() {
        // try with resources statement
        // the reader will be closed automatically when the try block closes
        try (
                var reader = new FileReader("file.txt");
        // var writeer = new FileWriter("...");
        ) {
            reader.read();
            new SimpleDateFormat().parse("");
        } catch (FileNotFoundException e) {
            // // e.printStackTrace();
            System.out.println("File does not exist.");
        }
        // because IOException is more gener
        // FileNotFoundException catch block
        // otherwise the FileNotFoundException catch block can never be reached
        catch (IOException | ParseException e) {
            // IOException ex = new FileNotFoundException();
            System.out.println("Could not read data.");
        }

    }

    public static void throwingExceptions() throws IOException {
        var account = new Account();
        try {
            account.deposit(-1);
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Logging");
            throw e;
        }
    }

    public static void customExceptions() {
        var account = new Account();
        try {
            account.withdraw(10);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause); // print cause of exception
            e.printStackTrace(); // print stack trace
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
