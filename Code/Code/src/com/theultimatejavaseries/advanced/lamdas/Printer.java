package com.theultimatejavaseries.advanced.lamdas;

public interface Printer {
    // abstract method
    void print(String message);

    // default method (negative java feature)
    // interfaces should not have implementation - they are contracts
    // default void printTwice(String message) {
    // System.out.println(message);
    // System.out.println(message);
    // }
}
