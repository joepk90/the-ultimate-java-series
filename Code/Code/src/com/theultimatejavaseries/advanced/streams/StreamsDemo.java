package com.theultimatejavaseries.advanced.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
 * - map / flatMap
 * - filter
 * - limit / skip
 * - sorted
 * - distinct
 * - peek
 * 
 * terminal operations:
 * - forEach
 * 
 * reducers:
 * - count
 * - anyMatch(predicate)
 * - allMatch(predicate)
 * - noneMatch(predicate)
 * - findFirst
 * - gindAny
 * - max(comparator)
 * - min(comparator)
 * 
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

    public static void sortingStreams() {
        var movies = List.of(
                new Movie("b", 10),
                new Movie("a", 20),
                new Movie("c", 30));

        // by default, a stream will maintain the order of the original data source
        movies.stream()
                .forEach(m -> System.out.println(m.getTitle()));

        // to use the sorted method (the movies class must implement the Comparable
        // interface: public class Movie implements Comparable<Movie>)
        // movies.stream()
        // .sorted().forEach(m -> System.out.println(m.getTitle()));

        // alternatively a function which matches the signiture of Comparable interface
        // can be passed to the sorted method
        movies.stream()
                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                .forEach(m -> System.out.println(m.getTitle()));

        // using the Comparator interface static comparing method
        // this simplifies our code as we can pass a method reference
        movies.stream()
                // .sorted(Comparator.comparing(Movie::getTitle))
                .sorted(Comparator.comparing(Movie::getTitle).reversed()) // pass a method reference
                .forEach(m -> System.out.println(m.getTitle()));

    }

    public static void gettingUniqueElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println); // returns: 10, 20, 30
    }

    public static void peekingElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        // peek method:
        // - is useful for troubleshooting problems
        // - intermediate operation (returns the stream)
        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("filtered: " + m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped: " + t))
                .forEach(System.out::println);
    }

    public static void simpleReducers() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        // get list count
        movies.stream().count();

        // checks if any element matches the condition
        var resultAnyMatch = movies.stream().anyMatch(m -> m.getLikes() > 20); // boolean
        System.out.println(resultAnyMatch); // true

        // checks if every element matches the condition
        var resultAllMatch = movies.stream().allMatch(m -> m.getLikes() > 20); // boolean
        System.out.println(resultAllMatch); // false

        // checks if no element matches the condition
        var resultNoneMatch = movies.stream().noneMatch(m -> m.getLikes() > 20); // boolean
        System.out.println(resultNoneMatch); // false

        // finds first element
        var resultFindFirst = movies.stream().findFirst().get();
        System.out.println(resultFindFirst.getTitle()); // a

        // finds any element
        var resultFindAny = movies.stream().findAny().get();
        System.out.println(resultFindAny.getTitle()); // a

        // finds element with the max (movie with max number of likes)
        var resultMax = movies.stream().max(Comparator.comparing(Movie::getLikes)).get();
        System.out.println(resultMax.getTitle()); // c

        // finds element with the min (movie with min number of likes)
        var resultMin = movies.stream().min(Comparator.comparing(Movie::getLikes)).get();
        System.out.println(resultMin.getTitle()); // a

    }

    public static void reducingStreams() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        Optional<Integer> sumOptional = movies.stream()
                .map(m -> m.getLikes())
                .reduce(Integer::sum);

        Integer sumInteger = movies.stream()
                .map(m -> m.getLikes())
                .reduce(0, Integer::sum);

        // reduce method process:
        // [10, 20, 30]
        // [30, 30]
        // [60]

        System.out.println(sumInteger); // 60
        System.out.println(sumOptional.orElse(0)); // 60
    }

    public static void collectors() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30));

        var resultList = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toList()); // returns List<Movie>

        System.out.println(resultList); // [movie.reference@1111111, movie.reference@22222222]

        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toSet()); // returns Set<Movie>

        System.out.println(result); // [movie.reference@1111111, movie.reference@22222222]

        // map (hash map):
        // key (title)
        // value (likes)
        // returns Map<Movie>
        var resultMap = movies.stream()
                .filter(m -> m.getLikes() > 10)
                // .collect(Collectors.toMap(m -> m.getTitle(), m -> m.getLikes()));
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));

        System.out.println(resultMap); // {b=20, c=30

        var resultMap2 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                // .collect(Collectors.toMap(Movie::getTitle, m -> m));
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));

        System.out.println(resultMap2); // {b=movie.reference@1111111, c=movie.reference@22222222}

        var resultSumInt = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));

        System.out.println(resultSumInt); // 50

        var resultSumDouble = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));

        System.out.println(resultSumDouble); // 50

        // summarizingInt: returns statistics about the values in our string
        var resultSummmerizingInt = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(resultSummmerizingInt); // {count=2, sum=50, min=20, average=25.000000, max=30}

        // joining: joins (concatontes) the elements (movie titles)
        var resultMapJoined = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));

        System.out.println(resultMapJoined); // b, c
    }

    public static void groupingElements() {
        var movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION));

        // returns: Map<Genre, List<Movie>
        var resultList = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

        System.out.println(resultList);
        // returns:
        // {
        // ACTION=[movie.reference@1111111, movie.reference@22222222],
        // THRILLER=[movie.reference@33333333]
        // }

        // returns: Map<Genre, Set<Movie>>
        var resultSet = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.toSet()));

        System.out.println(resultSet);
        // returns:
        // {
        // ACTION=[movie.reference@1111111, movie.reference@22222222],
        // THRILLER=[movie.reference@33333333]
        // }

        // count the number of movies in each category (genre)
        // returns: Map<Genre, Long>
        var resultCount = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.counting()));

        System.out.println(resultCount); // {THRILLER=1, ACTION=2}

        // returns: Map<Genre, String>
        var resultMappingjoin = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        // downstream collector is passed
                        Collectors.mapping(
                                Movie::getTitle,
                                Collectors.joining(", "))));

        System.out.println(resultMappingjoin); // {THRILLER=a, ACTION=b, c}
    }
}