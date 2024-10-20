package com.theultimatejavaseries.advanced.concurrency;

public class DownloadStatusWithSync implements DownloadStatusInterface {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    // method is thread safe
    public void incrementTotalBytes() {
        /**
         * Synchronized Keyword:
         * every object in java has a built in lock
         * java is going to use the built in lock from that
         * object and use it under the hood
         */

        // monitor object passed to the synchronized function
        synchronized (this) {
            totalBytes++;
        }

        // passing a reference to the class using "this" is bad practice
        // synchronized (this) {
        // totalBytes++;
        // }
    }
}
