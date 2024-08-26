package com.theultimatejavaseries.advanced.exceptions;

import java.io.IOException;

public class Account {
    private float balance;

    public void deposit(float value) throws IOException {
        if (value <= 0)
            throw new IOException();
    }

    public void withdraw(float value) throws AccountException {
        if (value > balance) {
            var fundsExeption = new InsufficientFundsException();
            var accountException = new AccountException();
            accountException.initCause(fundsExeption);
            throw accountException;
        }
    }
}