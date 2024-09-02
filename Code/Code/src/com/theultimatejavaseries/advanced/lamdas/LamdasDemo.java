package com.theultimatejavaseries.advanced.lamdas;

public class LamdasDemo {

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }

    public static void functionalInterfaces() {
        greet(new ConsolePrinter());
    }
}
