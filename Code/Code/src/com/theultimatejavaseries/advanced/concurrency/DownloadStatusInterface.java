package com.theultimatejavaseries.advanced.concurrency;

/*
 * DownloadStatusInterface
 * custom interface created o that both the DownloadStatus
 * and DownloadStatusWithLock classes can be passed to the
 * DownloadFileTaskWithStatusArg class.
 * 
 * Interface not a part of the course
 */

public interface DownloadStatusInterface {
    public abstract int getTotalBytes();

    public abstract void incrementTotalBytes();
}
