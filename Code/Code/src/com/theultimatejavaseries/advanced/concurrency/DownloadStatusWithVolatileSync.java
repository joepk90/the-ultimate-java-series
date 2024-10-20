package com.theultimatejavaseries.advanced.concurrency;

public class DownloadStatusWithVolatileSync {
    private Boolean isDone = false;
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

    public synchronized Boolean isDone() {
        return isDone;
    }

    public synchronized void done() {
        isDone = true;
    }

}
