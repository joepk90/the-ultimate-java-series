package com.theultimatejavaseries.advanced.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatusWithLock implements DownloadStatusInterface {
    private int totalBytes;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    // method is thread safe
    public void incrementTotalBytes() {
        lock.lock();

        // if the totalBytes execution fails,a deadlock could occur,
        // as the thread will remain locked forever
        // try / finally block used to always execute unlock mathod
        try {
            totalBytes++;
        } finally {
            lock.unlock();
        }
    }
}
