package MortgageProject;

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
}
