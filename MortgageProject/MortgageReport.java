package MortgageProject;

import java.text.NumberFormat;

import com.ultimatejavaseries.Main;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        double mortage = calculator.calculateMortgate(); // mortgage repayment amount
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------"); 
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println(); 
        System.out.println("PAYMENT SCHEDULE"); 
        System.out.println("----------------"); 
        for (short month = 1; month <= calculator.getYears() * Main.MONTHS_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
    
}
