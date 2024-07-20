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

    // a setter allows us to change dependancies used in an object,
    // throughout the lifetime of the program
    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }
}
