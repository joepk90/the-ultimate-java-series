package com.theultimatejavaseries.advanced.Executors;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send() {
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }

    // async approach to the above send method
    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(() -> send());
    }
}
