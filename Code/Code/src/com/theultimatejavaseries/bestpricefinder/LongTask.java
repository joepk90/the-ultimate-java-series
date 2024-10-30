package com.theultimatejavaseries.bestpricefinder;

public class LongTask {
    public static void simulate(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
