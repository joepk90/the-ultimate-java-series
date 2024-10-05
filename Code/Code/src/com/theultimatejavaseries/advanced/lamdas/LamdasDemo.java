package com.theultimatejavaseries.advanced.lamdas;

public class LamdasDemo {
    public String prefix = "-";

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

    public static void lamdaExpressions() {
        greet((String message) -> {
            System.out.println(message);
        });
        greet(message -> System.out.println(message));
        // Printer printer = message -> System.out.println(message);
    }

    public void variableCapture() {
        // public String prefix = "-";

        greet(message -> System.out.println(prefix + message));
    }
}
