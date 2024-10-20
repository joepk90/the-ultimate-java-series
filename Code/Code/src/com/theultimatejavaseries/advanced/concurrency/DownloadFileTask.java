package com.theultimatejavaseries.advanced.concurrency;

public class DownloadFileTask implements Runnable {
    private DownloadStatus status;

    Boolean showDownloadedBytes = false;

    public DownloadFileTask() {
    }

    // custom property to make class backwards compatible
    public DownloadFileTask(Boolean showDownloadedBytes) {
        this.showDownloadedBytes = showDownloadedBytes;
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        // prints: Downloading a file: Thread-<ID>

        if (showDownloadedBytes) {
            // for loop added to make it clear the process is running
            for (int i = 0; i < 10_000; i++) {

                // check for interrupt request
                if (Thread.currentThread().isInterrupted())
                    return;
                // System.out.println("Downloading byte " + i);
                status.incrementTotalBytes();
            }
        }

        // sleep will pause the thread
        // try {
        // Thread.sleep(5000);
        // } catch (InterruptedException e) {
        // // if a thread is sleeping and an interrupt request is sent to it,
        // // an exception is thrown
        // // this is why we need to handle a interrupt exception when pausing a thread
        // e.printStackTrace();
        // }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }

}
