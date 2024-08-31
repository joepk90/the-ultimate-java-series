package com.theultimatejavaseries.advanced.generics;

public class Utils {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Comparable> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    // Common Convention: K = key | V = Value
    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }
}
