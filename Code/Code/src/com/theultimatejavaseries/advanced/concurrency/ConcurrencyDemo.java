package com.theultimatejavaseries.advanced.concurrency;

public class ConcurrencyDemo {
    public static void processesAndThreads() {
        // returns number of active threads in the current process
        System.out.println(Thread.activeCount());

        // returns total number of available threads
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
