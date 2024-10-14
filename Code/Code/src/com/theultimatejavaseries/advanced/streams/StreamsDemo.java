package com.theultimatejavaseries.advanced.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Streams:
 * - a stream is a sequence of objects, but unlike a collection, s it doesn't
 * store data. it is a way of getting data out of a collection.
 * - streams were introduced in Java to allow us to process a collection of
 * objects in a declarative (or more accurately functional) way
 * - functional programming is a special type of declarative programming but
 * with additional concepts
 * 
 * ----------
 * 
 * Intermediate vs Terminal Stream Operations:
 * Intermediate Operations return a value (a new stream / pipe).
 * 
 * Terminal Operations start consuming a value but return void.
 * If we don’t call a terminal operation, nothing happens.
 * The Terminal operation invokes the intermediate transformations.
 * 
 * intermediate operations:
 * - map
 * - filter
 * 
 * terminal operations
 * - forEach
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

    public static void mappingElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        // map method
        movies.stream()
                // primative variations:
                // .mapToDouble(null)
                // .mapToLong(null)
                // .mapToInt(movie -> movie.getLikes())
                .map(movie -> movie.getTitle())
                .forEach(name -> System.out.println(name));

        // flatMap method
        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        // stream.forEach(list -> System.out.println(list)); // [1, 2, 3] [4, 5, 6]

        // convert each list to a stream
        // (each list item is returned as an interger to the original stream)
        stream.flatMap(list -> list.stream()).forEach(n -> System.out.println(n));
        // returns: 1, 2, 3, 4, 5, 6
    }

    public static void filteringElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        Predicate<Movie> isPopular = m -> m.getLikes() > 10;

        movies.stream()
                .filter(isPopular) // intermediate operation
                .forEach(m -> System.out.println(m.getTitle())); // terminal operation
    }

    /**
     * Slicing Streams:
     * - limit(n)
     * - skip(n)
     * - takeWhile(predicate)
     * - dropWhile(predicate)
     */
    public static void slicingStreams() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        // limit
        movies.stream()
                .limit(2) // returns a, b
                .forEach(m -> System.out.println(m.getTitle()));

        // skip
        movies.stream()
                .skip(2) // returns c
                .forEach(m -> System.out.println(m.getTitle()));

        /**
         * skip is useful for pagination - for example:
         * -> 1000 movies
         * -> 10 movies per page
         * -> show 3rd page
         * -> skip 20
         * 
         * code:
         * - skip( (page - 1) x pageSize)
         * - limit(10) = limit(pageSize)
         */

        // takeWhile (stops the moment the takewhile condition returns false)
        movies.stream()
                .takeWhile(m -> m.getLikes() < 30) // returns a, b
                .forEach(m -> System.out.println(m.getTitle()));

        // dropWhile (opposite to takeWhile - skips all elements which match condition)
        movies.stream()
                .dropWhile(m -> m.getLikes() < 30) // returns c
                .forEach(m -> System.out.println(m.getTitle()));

    }

}
