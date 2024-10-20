package com.theultimatejavaseries.advanced.concurrency.DownloadStatus;

import java.util.concurrent.atomic.LongAdder;

/**
 * Adder Classes:
 * internally, the (LongAdder) Adder object keeps an array of counters
 * that can grow on demand. so we don't have a single place in memory
 * where our values are stored, instead we have a set of array cells that
 * each hold a counter value.
 * 
 * different threads can modify these counter varaibles concurrently, which is
 * why Adder classes are faster than Atomic types, because they allow more
 * throughput.
 */

public class DownloadStatusWithAdder implements DownloadStatusInterface {
    private LongAdder totalBytes = new LongAdder();

    public int getTotalBytes() {
        return totalBytes.intValue();
        // LongAdder intValue calls the sum method, which adds up all the counter values
    }

    public void incrementTotalBytes() {
        totalBytes.increment();
    }
}
