package com.theultimatejavaseries.advanced.concurrency.DownloadStatus;

/**
 * Volatile Keyword
 * Another tool for writing thread safe code, but without the overhead of
 * synchronization - the volatile keyword.
 * 
 * The volatile keyword solves the visibility problem, but not the race
 * condition. It doesn't prevent two threads from simultaneously modifying data,
 * instead it ensures that if one thread changes data, other threads can see the
 * changes.
 */

public class DownloadStatusWithVolatileSync {
    private volatile Boolean isDone = false; // volatile means unstable
    private int totalBytes;
    private Object totalBytesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    // method is thread safe
    public void incrementTotalBytes() {

        // monitor object passed to the synchronized function
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public Boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }

    // Synchronized Keyword -> Volatile Keyword:
    // instead of using the synchronized keyword,
    // the volatile keyword is applied to the isDone field

    // public synchronized Boolean isDone() {
    // return isDone;
    // }

    // public synchronized void done() {
    // isDone = true;
    // }

}
