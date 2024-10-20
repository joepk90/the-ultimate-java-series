package com.theultimatejavaseries.advanced.concurrency;

public class DownloadStatusWithSignalling {
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
}
