import java.text.NumberFormat;
import java.util.Scanner;

public class MortgateCalculator {
    public static void main(String[] args) {
        int principle = (int) readNumber("Principle ($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortage = calculateMortgate(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Mortgage: " + mortgageFormatted);

        calculateRepayments(principle, annualInterest, years);
    }

    public static void calculateRepayments(int principle, float annualInterest, int years) {

        // duplication
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        // double monthlyRepaymentAmount = 0;

        System.out.println("MORTGATE"); 
        System.out.println("--------"); 
        // System.out.println("Monthly payments: " + monthlyRepaymentAmount ); 

        int paymentsCount = 0;
        float remainingBalance = (float) principle;
        System.out.println("remainingBalance conversion: " + remainingBalance);
        while (remainingBalance > 0) {           
             /**
             * FORMULA
             * - https://www.mortgageretirementprofessor.com/formulas.htm
             * - B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
             */
            remainingBalance = principle * (((1 + monthlyInterest) * numberOfPayments) - ((1 + monthlyInterest) * paymentsCount)) / (((1 + monthlyInterest) * numberOfPayments) -1);
            paymentsCount++;
            System.out.println("Payment " + paymentsCount + ": " + remainingBalance);
        }
    }

    public static double calculateMortgate(
            int principle,
            float annualInterest,
            byte years
        ) {
            final byte MONTHS_IN_YEAR = 12;
            final byte PERCENT = 100;
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
