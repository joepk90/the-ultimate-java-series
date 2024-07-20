package MortgageProject;

public interface TaxCalculator {
    // AVOID USING: new Java feature (fields in interfaces)
    // all fields are final (constants). Their value cannot change
    // all fields are static so can be used directly wihtout implementing a class
    // float minimumTax = 100;

    double calculateTax();

}
