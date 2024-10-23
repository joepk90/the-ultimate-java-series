package com.theultimatejavaseries.advanced.Executors;

public class MailService {
    public void send() {
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }
}
