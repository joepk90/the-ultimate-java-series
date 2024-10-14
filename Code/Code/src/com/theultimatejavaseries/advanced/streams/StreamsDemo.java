package com.theultimatejavaseries.advanced.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Streams:
 * - a stream is a sequence of objects, but unlike a collection, s it doesn't
 * store data. it is a way of getting data out of a collection.
 * - streams were introduced in Java to allow us to process a collection of
 * objects in a declarative (or more accurately functional) way
 * - functional programming is a special type of declarative programming but
 * with additional concepts
 */

public class StreamsDemo {
    public static void imperativeOrFunctional() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20));

        // Imperative Programming:
        // - statements that specify how something should be done
        int count = 0;
        for (var movie : movies)
            if (movie.getLikes() > 10)
                count++;

        // Declarative Programming:
        // - statements that specify how something should be done
        var count2 = movies.stream() // every collection in Java has a stream method
                .filter(movie -> movie.getLikes() > 10);

    }

    public static void creatingStreams() {
        // classes that implements the Collection interface can to return a stream
        // Collection<Integer> x;
        // x.stream();

        // stream examples
        int[] numbers = { 1, 2, 3 };
        Arrays.stream(numbers)
                .forEach(n -> System.err.println(n));

        // stream using static method on Stream interface
        Stream.of(1, 2, 3, 4);

        // generate infinite amount of random numbers using generate method (forEach
        // terminates the stream)
        var stream = Stream.generate(() -> Math.random());
        stream
                .limit(3) // disable limit to print execute operation infinite times
                .forEach(n -> System.out.println(n)); // prints 3 random numbers

        // generate infinite amount of random numbers using iterate method (forEach
        // terminates the stream)
        Stream.iterate(1, n -> n + 1)
                .limit(10) // disable limit to print execute operation infinite times
                .forEach(n -> System.out.println(n));
    }

}
