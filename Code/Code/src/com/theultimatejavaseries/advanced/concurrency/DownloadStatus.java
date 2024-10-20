package com.theultimatejavaseries.advanced.concurrency;

public class DownloadStatus implements DownloadStatusInterface {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        totalBytes++;

        /**
         * Incrementor Race Conditions / Thread Safe Issues:
         * the ++ incrementor operation is not thread safe and can caue race condition
         * issues
         * 
         * - a non-atmoic operation, because it involves mutliple steps
         * - whereas an atomic operation is like an atom - it canot be broken down
         * 
         * the ++ incrementor has 3 steps:
         * - value of this field has to be read from the main memory
         * and stored in the cpu
         * - next the cpu will increment this value
         * - the updated value will then be stored in the memory
         */
    }
}