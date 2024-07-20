package MortgageProject;

public interface TaxCalculator {
    // AVOID USING: new Java feature (fields in interfaces)
    // all fields are final (constants). Their value cannot change
    // all fields are static so can be used directly wihtout implementing a class
    // float minimumTax = 100;

    // AVOID USING: new Java feature - interface methods
    // avoid puttin implementation logic into an inteface.
    // see AbstractClassCalculator for how this type of logic should be handled
    // static double getTaxableIncome(double income, double expenses) {
    // return income - expenses;
    // }

    // AVOID USING: new Java feature - private methods
    // private double getTaxableIncome(double income, double expenses) {
    // return income - expenses;
    // }

    double calculateTax();
}
