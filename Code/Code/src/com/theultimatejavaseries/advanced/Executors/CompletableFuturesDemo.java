package com.theultimatejavaseries.advanced.Executors;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFuturesDemo {
    public static void creatingCompletableFutures() {

        /**
         * Common Pool:
         * the common pool is based on the number of available threads
         * returns the pool that is used by the CompletableFuture class
         */

        ForkJoinPool.commonPool();

        /**
         * Common Pool Threads:
         * the common pool is based on the number of available threads
         * the number of available threads can be seen using the following function
         */

        Runtime.getRuntime().availableProcessors();

        /**
         * CompletableFuture Class:
         * if the above pool does not work for your application, you can
         * always create a custom pool with fewer or more threads
         * without passing an executor, the task will run on a common pool
         * under the hood, this pool will a common pool from a ForkJoinPool instance
         */

        // example CompletableFuture with custom pool
        var executor = Executors.newFixedThreadPool(2);
        Runnable commonPooltask = () -> System.out.println("a");
        CompletableFuture.runAsync(commonPooltask, executor);

        // using CompletableFuture.runAsync
        // we can execute a task in an async fashion
        // we don't have to create an executor, submit a task, and then shut it down
        Runnable taskRunnable = () -> System.out.println("a");
        CompletableFuture.runAsync(taskRunnable);
        // returns CompletableFuture<Void>

        Supplier<Integer> taskSupplier = () -> 1;
        var futureSupply = CompletableFuture.supplyAsync(taskSupplier);
        // returns CompletableFuture<Integer>

        try {
            var result = futureSupply.get(); // blocking method
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void runningCodeOnCompeletion() {

        // CompletableFuture
        // CompletionStage x;
        // x.toCompletableFuture().thenRun(null);

        var future = CompletableFuture.supplyAsync(() -> 1);

        // executes on Main thread
        future.thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("done");
        });

        // execute this task asynchronously
        // this task will be passed to the underlying thread pool and executed async,
        // executing on alternative Thread (i.e. Thread-1)
        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("done");
        });

        // takes Consumer interface and returns result
        // executing on the Main thread
        future.thenAccept(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        // takes Consumer interface and returns result
        // executes on alternative Thread (i.e. Thread-1)
        future.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        // sleep request executed on Main thread to ensure other threads finish
        // operations first without sleep execution, printing operation may not
        // show because the Main thread has already stopped.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void handlingExceptions() {

        // exception is not displayed, because it it thrown o different thread
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather");
            throw new IllegalStateException();
        });

        try {
            // CompletableFuture: get exception
            // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
            // returns ExecutionException, cause by an IllegalStateException
            // future.get();

            /**
             * preventing an exception using the exceptionally method
             * the exceptionally method takes the Throwable object:
             * https://docs.oracle.com/javase/8/docs/api/java/lang/Throwable.html
             */

            // returns a new Completable Future, with default value of 1 (if exception is
            // thrown)
            var response = future.exceptionally(ex -> 1).get();
            System.out.println(response);

            // ExecutionException occurs if thread is sleeping, but it interrupted
        } catch (InterruptedException e) {
            e.printStackTrace();

            // ExecutionException caused if something goes wrong during execution
        } catch (ExecutionException e) {
            e.getCause(); // returns IllegalStateException
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void transformingCompletableFutures() {

        var future = CompletableFuture.supplyAsync(() -> 20);

        try {
            // execute this piece of code, after this task or this future is complete
            // thenApply returns a new CompletableFuture
            var result = future
                    .thenApply(celcius -> (celcius * 1.8) + 32)
                    .get(); // returns the converted value
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
