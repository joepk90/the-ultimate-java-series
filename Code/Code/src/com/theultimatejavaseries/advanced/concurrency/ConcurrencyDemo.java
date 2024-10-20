package com.theultimatejavaseries.advanced.concurrency;

import java.util.ArrayList;
import java.util.List;

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

    public static void interruptingThreads() {
        // when dealing with long lived tasks we should give our
        // users the ability to cancel
        Thread thread = new Thread(new DownloadFileTaskWithInterrupt());
        thread.start();

        // make the main thread wait for 1 second
        try {
            Thread.sleep(1000); // pause thread for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt Requests:
        // calling the interrupt method doesn't actually force the thread to stop
        // calling the interrupt method only sends an interrupt request to the thread
        // it is up to thread to decide if it should stop the current process
        thread.interrupt();
    }

    public static void raceConditions() {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTaskWithStatusArg(status));
            thread.start();
            threads.add(thread);
        }

        // Waiting for all 10 Theads to finish:
        // we can't use thread.join because it will make the main thread
        // wait for each download to finish
        // thread.join(); // blocking method
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
        /**
         * Race Condition Issue:
         * expected output is 100,000, however due to race conditions the figure is
         * around 710,000.
         * 
         * Race conditions issues are caused by the (++) incrementor logic]
         * in the DownloadStatus class.
         * 
         * This operation causes the inrementor logic to sometimes get the wrong value
         * in which incremement, because another thread has not finished it's own
         * incrementation process. this is causing values to be lost
         */
    }

    public static void confinmentStrategy() {
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTaskWithStatus> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var task = new DownloadFileTaskWithStatus();
            tasks.add(task);

            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        // Wait for all 10 Theads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var totalByes = tasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(Integer::sum);

        System.out.println(totalByes);
        // totalBytes returns 100000
        // the race condition seen in the raceConditions method have been solved
    }
}
