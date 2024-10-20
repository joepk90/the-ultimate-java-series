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

/**
 * Thread Scheduler
 * The Java Virtual Machine has a Thread Scheduler.
 * 
 * The job of this scheduler is to decide what threads to run for how long.
 * If there are more tasks than avaible threads, the schdeudler switches between
 * these tasks
 * giving each a slice of the CPU time.
 * 
 * This happens so fast it gives us the illusion that these tasks are being
 * executed in parrallel.
 * But that’s parrallelism at software level.
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

        // when this program runs, the code to download a file will be executed in a
        // seperate thread
        // start 10 threads using a for loop
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }

    }

    public static void pausingThreads() {
        System.out.println(Thread.currentThread().getName()); // returns thread name (main)

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTaskWithSleep());
            thread.start();
        }

        // because the thread gets paused, each thread takes 5 seconds to complete
        // to complete
    }

    public static void joiningThreads() {
        Thread thread = new Thread(new DownloadFileTaskWithSleep());
        thread.start();

        // the join method tells the current thread to wait for the completion of
        // another thread.
        // this means that while this thread is waiting, it cannot do other things... it
        // is blocked
        // this can be problematic on the main thread, as it can block the executions of
        // user interactions
        try {
            thread.join(); // joins the main thread with the DownloadFileTask thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready to be scanned.");
    }
}
