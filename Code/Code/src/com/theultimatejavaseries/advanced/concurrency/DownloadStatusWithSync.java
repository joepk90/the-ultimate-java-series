package com.theultimatejavaseries.advanced.concurrency;

public class DownloadStatusWithSync implements DownloadStatusInterface {
    private int totalBytes;
    private int totalFiles;

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

    /**
     * Synchronized Keyword (Bad Practice):
     * two mathods that use the same monitor object cannot be called at the same
     * time.
     * 
     * if one thread is calling the incremementTotalFiles method, another thread
     * cannot call the incrementTotalBytes method, because both methods are using
     * the same monitor object (this)
     * 
     * only one thread at a time can call a synchronous method of this object - this
     * is bad practice
     */

    public void incremementTotalFiles() {
        synchronized (this) {
            totalFiles++;
        }
    }

    public int getTotalFiles() {
        return totalFiles;
    }

}
