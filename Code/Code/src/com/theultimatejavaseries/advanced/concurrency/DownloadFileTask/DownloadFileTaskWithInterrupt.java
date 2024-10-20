package com.theultimatejavaseries.advanced.concurrency.DownloadFileTask;

public class DownloadFileTaskWithInterrupt implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        // prints: Downloading a file: Thread-<ID>

        // for loop added to make it clear the process is running
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            // check for interrupt request
            if (Thread.currentThread().isInterrupted())
                return;
            System.out.println("Downloading byte " + i);
        }

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
}
