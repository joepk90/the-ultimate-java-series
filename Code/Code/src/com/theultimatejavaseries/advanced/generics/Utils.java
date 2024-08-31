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

    public static void printUser(User user) {
        System.out.println(user);
    }

    // class CAP#1 (capture class) extends User {}
    // similar to - class Instructor extends User {}
    public static void printUsers(GenericList<? extends User> users) {
        User x = users.get(0);

        // adding is not possible extends is used
        // users.add()
    }
}
