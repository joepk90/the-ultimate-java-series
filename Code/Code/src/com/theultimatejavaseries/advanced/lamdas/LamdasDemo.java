package com.theultimatejavaseries.advanced.lamdas;

public class LamdasDemo {
    public String prefix = "-";

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }

    // signiture of this method matches the print method of the Printer interface
    public static void print(String message) {
    }

    public void instancePrint(String message) {
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

    public static void methodReference() {
        // greet(message -> System.out.println(message));

        // Class/Object::method
        greet(System.out::println);

        // examples of passing static method references to the greet method
        greet(message -> print(message));
        greet(LamdasDemo::print);

        // examples of passing instance method references to the greet method
        var demo = new LamdasDemo();
        greet(message -> demo.instancePrint(message));
        greet(demo::instancePrint);
    }
}
