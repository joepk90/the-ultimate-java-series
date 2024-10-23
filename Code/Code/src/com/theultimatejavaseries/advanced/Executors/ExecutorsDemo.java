package com.theultimatejavaseries.advanced.Executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

// import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsDemo {

    public static void creatingThreadPools() {

        // creating a ThreadPoolExecutor explicitly is a bit difficult:
        // new ThreadPoolExecutor(0, 0, 0, null, null)

        // which is why you usually use the Factory methods on the Executors class

        // returns executor with a single thread - not something we use that often
        // Executors.newSingleThreadExecutor();

        // returns a thread pool with given number of worker threads
        // Executors.newFixedThreadPool(2);

        // returns instance of the scheduled threads pool executor
        // Executors.newScheduledThreadPool(2);

        // ExectorService Interface:
        var executor = Executors.newFixedThreadPool(2);

        // returns: ThreadPoolExecutor (a thread pool with a number of worker threads)
        System.out.println(executor.getClass().getName());

        // run a task on a seperate thread (to this executors thread pool):
        // executor.submit(() -> {
        // System.out.println(Thread.currentThread().getName()); // pool-1-thread-1
        // });

        /**
         * if you have 1000 tasks, we don't have to worry about creating too many
         * threads, and running out of memory. we simply submit those tasks to this
         * executor (to this thread pool), and this pool will assign out tasks to worker
         * threads.
         */

        // use try / finally statement to shutdown the executor even if a task fails
        try {
            // submitting multiple tasks to the executors thread pool
            // internally this executor maintains a queue.
            // every task we submit goes in this queue and waits for an available thread
            for (int i = 0; i < 10; i++) {
                executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                    /*
                     * returns:
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-2
                     * pool-1-thread-1
                     */
                });
            }
        } finally {
            /**
             * when an executor is started and task submitted, it never stops.
             * it waits in the memory waiting for new tasks...
             * this is because executor thinks there might be more tasks coming in the
             * future.
             * 
             * to stop an executor, we have to explcity shit down an excutor to terminate
             * our program.
             */

            // shutdown an executor (waiting for the current task to finish)
            executor.shutdown();

            // shutdown an executor (without waiting for the current task to finish)
            // executor.shutdownNow();
        }
    }

    /**
     * The ExecutorService submit method which accepts either of the following
     * interfaces:
     * 
     * - Callable:
     * https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Callable.html
     * 
     * - Runnable:
     * https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
     * 
     */

    public static void callablesAndFutures() {
        var executor = Executors.newFixedThreadPool(2);
        try {
            // because lambda expression returns a value, it represents a Callable object:
            // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Callable.html
            var future = executor.submit(() -> {
                LongTask.simulate(); // similate long running task (3000)
                return 1;
            });

            /**
             * Future Object:
             * with this future object we can get the result of the result of this operation
             */

            // get the value of this opertation
            // get is overloaded which offers timeout functionality
            // future.get(2000);
            // future.get();

            // cancel: cancel the operation
            // future.cancel(true);

            // isCancelled: check to see if the operation has been cancelled
            // future.isCancelled();

            // isCancelled: check to see if the operation is complete or done
            // future.isDone();

            System.out.println("Do more work");

            // get will block the current thread until the result of this operation is ready
            // eventually it will return a value, or fail
            try {
                var result = future.get(); // synchronous code (blocking)
                System.out.println(result); // returns 1
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        } finally {
            executor.shutdown();
        }
    }

    public static void implementingAsynchronousAPI() {
        var service = new MailService();

        // synchronous (blocking) operation - (3 seconds wait)
        service.sendAsync();

        // service.send much complete before seeing this print operation is executed
        System.out.println("Hello world");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
