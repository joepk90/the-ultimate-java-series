package com.theultimatejavaseries.advanced;

// import java.io.IOException;

import com.theultimatejavaseries.advanced.exceptions.ExceptionsDemo;

public class Main {
    public static void main(String[] args) {
        exceptions();
    }

    public static void exceptions() {
        // ExceptionsDemo.show();
        // ExceptionsDemo.catchingExceptions();

        // try {
        // ExceptionsDemo.throwingExceptions();
        // } catch (Throwable e) {
        // // throwable used to catch all possible exceptions
        // System.out.println("An unexpected error occurred.");
        // }

        ExceptionsDemo.customExceptions();
    }
}
