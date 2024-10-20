package com.theultimatejavaseries.advanced.concurrency.DownloadFileTask;

import com.theultimatejavaseries.advanced.concurrency.DownloadStatus.DownloadStatusInterface;

public class DownloadFileTaskWithStatusArg implements Runnable {
    private DownloadStatusInterface status;

    public DownloadFileTaskWithStatusArg(DownloadStatusInterface status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted())
                return;
            status.incrementTotalBytes();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
