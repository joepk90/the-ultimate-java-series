import MortgageProject.Console;
import MortgageProject.MortgageReport;

public class MortgateCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principle = (int) Console.readNumber("Principle ($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        MortgageReport.printMortgage(principle, annualInterest, years);
        MortgageReport.printPaymentSchedule(principle, annualInterest, years); 
    }

    public static double calculateBalance(int principle, float annualInterest, int years, short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

         /**
         * FORMULA
         * - https://www.mortgageretirementprofessor.com/formulas.htm
         * - B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
         */
        double balance = principle
            * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgate(
            int principle,
            float annualInterest,
            byte years
        ) {
            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
            

            double mortage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

            return mortage;
    }
}
