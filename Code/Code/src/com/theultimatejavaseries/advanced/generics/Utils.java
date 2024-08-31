package com.theultimatejavaseries.advanced.generics;

public class Utils {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Comparable> T max(T first, T second) {
        return (first.compareTo(second) > 0) ? first : second;
    }
}
