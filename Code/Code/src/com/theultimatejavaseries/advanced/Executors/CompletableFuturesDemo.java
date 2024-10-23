package com.theultimatejavaseries.advanced.Executors;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.concurrent.CompletableFuture;
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
}
