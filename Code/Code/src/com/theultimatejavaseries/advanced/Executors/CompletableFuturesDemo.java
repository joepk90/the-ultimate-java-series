package com.theultimatejavaseries.advanced.Executors;

import java.util.concurrent.ForkJoinPool;

import java.util.concurrent.CompletableFuture;
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

    }
}
