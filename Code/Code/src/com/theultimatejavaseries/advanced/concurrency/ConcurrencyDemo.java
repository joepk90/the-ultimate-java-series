package com.theultimatejavaseries.advanced.concurrency;

/**
 * Thread class:
 * The Thread class constructor is overloaded.
 * The version that is most often used takes a Runnable object as the argument,
 * which implements the Runnable interface.
 */

/**
 * Runnable interface:
 * https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
 * 
 * The Runnable interface represents a task to be run on a thread.
 * It is a simple interface with a single method:
 * - Run
 */

public class ConcurrencyDemo {
    public static void processesAndThreads() {
        // returns number of active threads in the current process
        System.out.println(Thread.activeCount());

        // returns total number of available threads
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static void startingThreads() {
        // System.out.println(Thread.currentThread().getId()); // returns thread ID (1)
        System.out.println(Thread.currentThread().getName()); // returns thread name (main)
        
        // when this program runs, the code to download a file will be executed in a seperate thread
        // start 10 threads using a for loop
        for (int i = 0; i <10; i++) { 
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
        
    }
}
