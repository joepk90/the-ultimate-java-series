package com.theultimatejavaseries.advanced.concurrency;

public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        // race conditions issues are caused by the (++) incrementor logic
        totalBytes++;

        // this operation causes the inrementor logic to sometimes get the wrong value
        // in which incremement, because another thread has not finished it's own
        // incrementation process. this is causing values to be lost

        /**
         * Incrementor:
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
