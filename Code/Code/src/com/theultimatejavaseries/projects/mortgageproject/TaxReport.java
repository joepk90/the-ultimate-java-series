package com.theultimatejavaseries.projects.mortgageproject;

public class TaxReport {
    private TaxCalculator calculator;

    // constructor injection (dependancy injection)
    public TaxReport(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    public void show() {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

    // method injection (dependancy injection)
    public void show(TaxCalculator calculator) {
        var tax = calculator;
        System.out.println(tax);
    }

    // a setter allows us to change dependancies used in an object,
    // throughout the lifetime of the program
    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }
}
