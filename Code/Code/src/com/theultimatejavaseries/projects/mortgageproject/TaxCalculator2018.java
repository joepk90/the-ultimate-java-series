package com.theultimatejavaseries.projects.mortgageproject;

public class TaxCalculator2018 extends AbstractClassCalculator {
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        getTaxableIncome(taxableIncome, taxableIncome);

        // TaxCalculator.minimumTax = 10; not possible - interface fields are final
        return taxableIncome * 0.3;
    }
}
