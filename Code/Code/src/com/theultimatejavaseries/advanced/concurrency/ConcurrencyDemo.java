package com.theultimatejavaseries.advanced.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.theultimatejavaseries.advanced.concurrency.DownloadFileTask.DownloadFileTask;
import com.theultimatejavaseries.advanced.concurrency.DownloadFileTask.DownloadFileTaskWithInterrupt;
import com.theultimatejavaseries.advanced.concurrency.DownloadFileTask.DownloadFileTaskWithSignalling;
import com.theultimatejavaseries.advanced.concurrency.DownloadFileTask.DownloadFileTaskWithSleep;
import com.theultimatejavaseries.advanced.concurrency.DownloadFileTask.DownloadFileTaskWithStatus;
import com.theultimatejavaseries.advanced.concurrency.DownloadFileTask.DownloadFileTaskWithStatusArg;
import com.theultimatejavaseries.advanced.concurrency.DownloadFileTask.DownloadFileTaskWithVolatile;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatus;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusInterface;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusWithAdder;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusWithAtomic;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusWithLock;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusWithSignalling;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusWithSync;
import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusWithVolatileSync;

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

    // syncornization
    public static void locksStrategy() {
        DownloadStatusInterface status = new DownloadStatusWithLock();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTaskWithStatusArg(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    public static void synchronizedKeywordStrategy() {
        DownloadStatusInterface status = new DownloadStatusWithSync();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTaskWithStatusArg(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    public static void volatileKeyword() {
        DownloadStatusWithVolatileSync status = new DownloadStatusWithVolatileSync();

        var thread1 = new Thread(new DownloadFileTaskWithVolatile(status));

        // without synchronization logic (the syncronized or volatile keyword) being
        // used the thread will wait indefinitely as it does not see the
        // change to the isDone field
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }

    // thread signalling with wait/notify
    public static void threadSignalling() {
        DownloadStatusWithSignalling status = new DownloadStatusWithSignalling();

        var thread1 = new Thread(new DownloadFileTaskWithSignalling(status));
        var thread2 = new Thread(() -> {

            // while loop wastes cpu cycles, because it runs continuously
            while (!status.isDone()) {

                /**
                 * s
                 * Wait Method (inherited from the Object class):
                 * calling the wait method will cause the thread to sleep until another thread
                 * notifies this thread that the state of the status object has changed
                 */
                synchronized (status) {
                    /**
                     * Wait Method:
                     * calling the wait method prevents the while loop from executing 1,000,000
                     * times. when the nofifyAll function is called, the while loop starts again
                     */
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }

    public static void atomicObjects() {
        DownloadStatusInterface status = new DownloadStatusWithAtomic();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTaskWithStatusArg(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    public static void adders() {
        DownloadStatusInterface status = new DownloadStatusWithAdder();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTaskWithStatusArg(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }

    /**
     * Synchronised Collectins:
     * synchronized collections acheive thread safety by using locks.
     * when a thead gets access to a synchronous collection, the entire collection
     * gets locked and other threads have to wait. this works well in most cases,
     * but it can have an impact on performance and scalability as number of threads
     * and concurrent operations increase.
     */
    public static void synchronizedCollections() {
        // Collection<Integer> collection = new ArrayList<>(); // race condition
        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(collection);
    }

    /**
     * Concurrent Collections:
     * https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html
     * in situations where synchronized collections are causing performance issues,
     * we can use concurrent collections.
     * 
     * concurrent collections use the partition technique, to allow concurrency.
     * they divide their data into segments, and different threads can concurrently
     * work with different segements. but only one thread at a time can access a
     * given
     * segment.
     * 
     * concurrent collections are faster than synchronized collections because they
     * don't use synchronization.
     */
    public static void concurrentCollections() {
        // Map<Integer, String> map = new HashMap(); // race conditions
        Map<Integer, String> map = new ConcurrentHashMap<>();

        var thread1 = new Thread(() -> {
            map.put(1, "a");
        });

        var thread2 = new Thread(() -> {
            map.put(2, "b");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(map);

    }
}
