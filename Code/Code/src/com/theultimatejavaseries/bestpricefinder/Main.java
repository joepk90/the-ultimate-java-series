package com.theultimatejavaseries.bestpricefinder;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Best Price Finder Project
 * - project from Part 3 - Section 8 (The Execution Framework)
 */

public class Main {
    public static void main(String[] args) {
        // my approach
        // BestPriceFinder.getQuotes();

        // solution
        solution();
    }

    public static void solution() {
        var start = LocalTime.now();

        var service = new FlightService();
        var futures = service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duraction = Duration.between(start, end);
                    System.out.println("Retrieve all quote  in " + duraction.toMillis() + " msec");
                });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
