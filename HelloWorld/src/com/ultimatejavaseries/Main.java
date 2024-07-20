package com.ultimatejavaseries;

import MortgageProject.Console;
import MortgageProject.MortgageCalculator;
import MortgageProject.MortgageReport;
import MortgageProject.TaxCalculator2018;
import MortgageProject.TaxReport;

public class Main {
    public static void main(String[] args) {
        // Main.runMortgageCalculator();
        Main.runTaxCalculator();
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

    public static void runTaxCalculator() {
        System.out.println("TAX CALCULATOR LOGIC: ");
        // poor mans dependancy injection
        var calculator = new TaxCalculator2018(100_000);
        var report = new TaxReport(calculator);
    }
}
