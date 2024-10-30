package com.theultimatejavaseries.bestpricefinder;

import java.util.concurrent.CompletableFuture;

/**
 * My logic for completing the Best Price Finder Project
 */
public class BestPriceFinder {
    public static Quote getQuote(String site, Integer price) {
        System.out.println("Getting quote from " + site);
        return new Quote(site, price);
    }

    public static void getQuotes() {
        var quoteOne = CompletableFuture.supplyAsync(() -> getQuote("site1", 100));
        var quoteTwo = CompletableFuture.supplyAsync(() -> getQuote("site2", 105));
        var quoteThree = CompletableFuture.supplyAsync(() -> getQuote("site3", 108));

        var all = CompletableFuture.allOf(quoteOne, quoteTwo, quoteThree);

        all.thenRun(() -> {
            quoteOne.thenAccept(qoute -> System.out.println(qoute));
            quoteTwo.thenAccept(qoute -> System.out.println(qoute));
            quoteThree.thenAccept(qoute -> System.out.println(qoute));
        }).thenAccept(a -> {
            // Executors.
            // Runtime.getRuntime().
            var runTime = System.nanoTime() / 1_000_000;
            System.out.println("Retreived all quotes in " + runTime + " msec");
        });

    }
}
