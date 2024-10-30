package com.theultimatejavaseries.bestpricefinder;

public class Main {
    public static void main(String[] args) {
        // my approach
        // BestPriceFinder.getQuotes();

        var service = new FlightService();
        service.getQuote("site1")
                .thenAccept(System.out::println);

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
