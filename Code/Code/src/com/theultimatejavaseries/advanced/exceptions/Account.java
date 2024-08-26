package com.theultimatejavaseries.advanced.exceptions;

public class Account {
    public void deposit(float value) {
        if (value <= 0)
            throw new IllegalArgumentException();
    }
}
