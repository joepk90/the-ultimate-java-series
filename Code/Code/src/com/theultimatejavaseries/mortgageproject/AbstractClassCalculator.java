package com.theultimatejavaseries.mortgageproject;

public abstract class AbstractClassCalculator implements TaxCalculator {

    protected double getTaxableIncome(double income, double expenses) {
        return income - expenses;
    }
}
