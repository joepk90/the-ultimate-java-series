package com.theultimatejavaseries.advanced.concurrency;

public class DownloadFileTaskWithSleep implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        // prints: Downloading a file: Thread-<ID>

        // sleep will pause the thread
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
