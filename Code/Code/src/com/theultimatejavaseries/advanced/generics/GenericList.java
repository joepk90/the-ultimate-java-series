package com.theultimatejavaseries.advanced.generics;

public class GenericList<T> {
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}

// Any letter can be used, however the below are common conventions
// T: Type / Template
// E: Element