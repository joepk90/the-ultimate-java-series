package com.theultimatejavaseries.advanced.concurrency;

public class Main {
    public static void main(String[] args) {
        // ConcurrencyDemo.processesAndThreads();
        // ConcurrencyDemo.startingThreads();
        // ConcurrencyDemo.pausingThreads();
        // ConcurrencyDemo.joiningThreads();
        // ConcurrencyDemo.interruptingThreads();
        // ConcurrencyDemo.raceConditions();
        // ConcurrencyDemo.confinmentStrategy();
        // ConcurrencyDemo.locksStrategy();
        // ConcurrencyDemo.synchronizedKeywordStrategy();
        ConcurrencyDemo.volatileKeyword();
    }
}

/**
 * Strategies for Thread Safe Code:
 * There are a few strategies for writing thread safe code. Code that can be
 * safely executed across multiple threads.
 * 
 * 
 * - Confinement
 * Confinement is the strategy of simply not sharing data across threads in the
 * first place, and is usually the simplest solution.
 * 
 * - Immutability
 * Using Immutable to unchangeable objects. An object is immutable if its state
 * or data cannot be changed after it has been created.
 * 
 * Sharing Immutable objects between threads is fine, because these threads will
 * only be able to read the immutable objects. They cannot modify them.
 * 
 * - Synchronization
 * Preventing multiple threads from accessing the same object concurrently. This
 * can be achieved by using locks. Synchronization forces the code to run
 * sequentially, which is against the idea of concurrency. Also implementing
 * synchronization is challenging and error prone.
 * 
 * Deadlock
 * One of the problems that can be run into when trying to implement
 * synchronization is a deadlock. A Deadlock is when two threads wait for each
 * other indefinitely.
 * 
 * - Atomic Objects
 * Another strategy is using atomic classes, such as AtomicInteger. These
 * classes allow us to achieve thread safety without using locks. If we
 * increment on an AtomicInteger instance, the java virtual machine will execute
 * the increment operation as one single atomic operation. It won’t break it
 * down into 3 small operations.
 * 
 * - Partitioning
 * Partitioning data into segments that can be accessed concurrently. Java
 * provides a number of collection classes that support concurrency using
 * partitioning.
 * 
 * Using Partitioning allows multiple threads to access a Collection object, but
 * only one thread at a time can access a segment in that collection.
 * 
 */