package com.theultimatejavaseries.advanced.streams;

import java.util.List;

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

}
