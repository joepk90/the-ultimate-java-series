package com.theultimatejavaseries.advanced.lamdas;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
