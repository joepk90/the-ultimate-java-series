package com.theultimatejavaseries.advanced.concurrency.DownloadFileTask;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        // prints: Downloading a file: Thread-<ID>
    }
}
