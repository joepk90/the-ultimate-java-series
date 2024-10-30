package com.theultimatejavaseries.projects.bestpricefinder;

public class LongTask {
    public static void simulate(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
