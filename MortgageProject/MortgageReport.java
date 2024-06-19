package MortgageProject;

import java.text.NumberFormat;

import com.ultimatejavaseries.MortgateCalculator;

public class MortgageReport {

    public static void printMortgage(int principle, float annualInterest, byte years) {
        double mortage = MortgateCalculator.calculateMortgate(principle, annualInterest, years); // mortgage repayment amount
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------"); 
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(int principle, float annualInterest, byte years) {
        System.out.println(); 
        System.out.println("PAYMENT SCHEDULE"); 
        System.out.println("----------------"); 
        for (short month = 1; month <= years * MortgateCalculator.MONTHS_IN_YEAR; month++) {
            double balance = MortgateCalculator.calculateBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
    
}
