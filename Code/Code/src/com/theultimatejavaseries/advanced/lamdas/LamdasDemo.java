package com.theultimatejavaseries.advanced.lamdas;

public class LamdasDemo {

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }

    public static void functionalInterfaces() {
        greet(new ConsolePrinter());
    }

    public static void anonymousInnerClasses() {
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }
}
