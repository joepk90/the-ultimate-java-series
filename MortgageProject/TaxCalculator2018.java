package MortgageProject;

public class TaxCalculator2018 implements TaxCalculator {
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        // TaxCalculator.minimumTax = 10; not possible - interface fields are final
        return taxableIncome * 0.3;
    }
}
