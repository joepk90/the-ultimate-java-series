package com.theultimatejavaseries.advanced.lamdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    /**
     * Built-In Functional Interfaces
     * https://docs.oracle.com/javase/8/docs/api/?java/util/function/package-summary.html
     * 
     * - Consumers
     * - Suppliers
     * - Functions
     * - Predicates
     */

    /**
     * Consumers:
     * The Consumer interface represents an operation that takes a single argument
     * and returns no result.
     * This is why is it is called a consumer, because it consumes a value
     * 
     * Example Consumer Interfaces:
     * https://docs.oracle.com/javase/8/docs/api/?java/util/function/package-summary.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/IntConsumer.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleConsumer.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html
     */

    public static void consumerInterfaces() {
        List<Integer> intList = List.of(1, 2, 3);

        // Imperative Programming (for, if/else, switch/case):
        // how should be done...
        for (var item : intList)
            System.out.println(item);

        // Declarative Programming:
        // what should be done...
        intList.forEach(item -> System.out.println(item)); // the forEach method requires a Consumer
        // the forEach method consumes an argument, but does not return the value

        // chaining consumers example
        List<String> stringList = List.of("a", "b", "c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        stringList.forEach(print.andThen(printUpperCase).andThen(print));

    }

    /**
     * Suppliers:
     * The Opposite of the Consumer interface. It represents an operation that takes
     * no input
     * and returns a value. It supplies a value.
     * 
     * Example Supplier Interfaces:
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleSupplier.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/IntSupplier.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/LongSupplier.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/BooleanSupplier.html
     */

    public static void supplierInterfaces() {
        Supplier<Double> getRandom = () -> Math.random();

        // Lazy Evaluation:
        // logic passed to the Supplier interface won't be called until the get method
        // is called
        var random = getRandom.get();
        System.out.println(random);

    }

    /**
     * Functions:
     * The Function interface represents a function that can map a value to a
     * different value.
     * 
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/IntFunction.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/ToIntFunction.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/IntToLongFunction.html
     */

    public static void functionInterfaces() {
        Function<String, Integer> map = str -> str.length();
        var length = map.apply("sky");
        System.out.println(length);

        // "Key:value"

        // transformations:
        // first: "Key=value"
        // second: "key=value"
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        // declarative programming (what needs to be done, not how it should be done)
        var resultOne = replaceColon
                .andThen(addBraces)
                .apply("Key:value");
        System.out.println(resultOne);

        var resultTwo = addBraces.compose(replaceColon).apply("Key:value");
        System.out.println(resultTwo);
    }

    /**
     * Predicates:
     * The Predicate interface represents an operation that takes an object,
     * and checks to see if that object satisfies some criteria.
     * 
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html
     * https://docs.oracle.com/javase/8/docs/api/java/util/function/IntPredicate.html
     */

    public static void predicateInterfaces() {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        var result = isLongerThan5.test("sky");
        System.out.println(result);

        // combining predicates
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");
        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        Predicate<String> hasLeftOrRightBraces = hasLeftBrace.or(hasRightBrace);
        Predicate<String> hasNoLeftBrace = hasLeftBrace.negate(); // negate inverts the condition

        var resultAnd = hasLeftAndRightBraces.test("{key:value}");
        System.out.println("hasLeftAndRightBraces: " + resultAnd);

        var resultOr = hasLeftOrRightBraces.test("{key:value}");
        System.out.println("hasLeftOrRightBraces: " + resultOr);

        var resultNoLeftBrace = hasNoLeftBrace.test("{key:value}");
        System.out.println("hasNoLeftBrace: " + resultNoLeftBrace);
    }
}
