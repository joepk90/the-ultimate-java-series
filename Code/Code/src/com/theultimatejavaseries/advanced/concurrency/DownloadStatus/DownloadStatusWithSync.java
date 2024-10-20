package com.theultimatejavaseries.advanced.concurrency.DownloadStatus;

/*
 * Synchronization Keysword:
 * as best practice, don't use the synchronized keyword in new code
 */

public class DownloadStatusWithSync implements DownloadStatusInterface {
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();

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
        synchronized (totalBytesLock) {
            totalBytes++;
        }

        // passing a reference to the class using "this" is bad practice
        // synchronized (this) {
        // totalBytes++;
        // }
    }

    public void incremementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    public int getTotalFiles() {
        return totalFiles;
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

    // using the synchronized keyword on the method definition,
    // is exactly the same as the below method, so can cause the same problems
    // public synchronized void incremementTotalFiles() {}

    // public void incremementTotalFiles() {
    // synchronized (this) {
    // totalFiles++;
    // }
    // }

    // public int getTotalFiles() {
    // return totalFiles;
    // }

}
