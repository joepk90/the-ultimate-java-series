package com.theultimatejavaseries.advanced.concurrency;

public class DownloadFileTaskWithSignalling implements Runnable {
    private DownloadStatusWithSignalling status;

    public DownloadFileTaskWithSignalling(DownloadStatusWithSignalling status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted())
                return;
            status.incrementTotalBytes();
        }

        status.done();

        synchronized (status) {
            // status.notify();
            status.notifyAll(); // useful for notifying multiple threads
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
