package com.theultimatejavaseries.projects.mortgageproject;

/**
 * Mortgate Calculator Project
 * - project from Part 1 - Section 2 (Types)
 */

public class Main {
    public static void main(String[] args) {
        Main.runMortgageCalculator();
    }

    public static void runMortgageCalculator() {
        int principle = (int) Console.readNumber("Principle ($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principle, annualInterest, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
