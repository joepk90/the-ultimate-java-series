package com.theultimatejavaseries.advanced.concurrency.DownloadStatus;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic Objects:
 * atomic objects are good for implementing counters.
 * however if you have multiple threads updating a value frequently,
 * it's better to use other classes in java - which are faster.
 * - LongAdder
 * - DoubleAdder
 * 
 */

public class DownloadStatusWithAtomic implements DownloadStatusInterface {
    private AtomicInteger totalBytes = new AtomicInteger();

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public void incrementTotalBytes() {
        totalBytes.incrementAndGet();
    }
}
