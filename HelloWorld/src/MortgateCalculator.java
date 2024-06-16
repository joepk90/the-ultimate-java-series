import java.text.NumberFormat;
import java.util.Scanner;

public class MortgateCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principle = (int) readNumber("Principle ($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principle, annualInterest, years);
        printPaymentSchedule(principle, annualInterest, years); 
    }

    private static void printMortgage(int principle, float annualInterest, byte years) {
        double mortage = calculateMortgate(principle, annualInterest, years); // mortgage repayment amount
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
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
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

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextFloat();

            if (value >= min && value <= max)
                break;

            System.out.println("Enter a value between " + min + " and " + max + "30"); 
        }

        // scanner.close(); // closing scanner breaks script?
        return value;
    }
}
