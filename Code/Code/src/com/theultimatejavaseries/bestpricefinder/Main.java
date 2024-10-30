package com.theultimatejavaseries.bestpricefinder;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // my approach
        // BestPriceFinder.getQuotes();

        var service = new FlightService();
        service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
