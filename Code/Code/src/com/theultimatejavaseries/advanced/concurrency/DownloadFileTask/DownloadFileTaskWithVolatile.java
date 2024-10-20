package com.theultimatejavaseries.advanced.concurrency.DownloadFileTask;

import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusWithVolatileSync;

public class DownloadFileTaskWithVolatile implements Runnable {
    private DownloadStatusWithVolatileSync status;

    public DownloadFileTaskWithVolatile(DownloadStatusWithVolatileSync status) {
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

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
