import java.text.NumberFormat;
import java.util.Scanner;

public class MortgateCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

         /**
         * Principle (Loan)
         */
        int principle = 0;
        while(true) {
            
            System.out.print("Principle ($1k - $1M): ");
            principle = scanner.nextInt();

            if (principle >= 1000 && principle <= 1_000_000) {
                break;
            }

            System.out.println("Enter a number between 1,000 and 1,000,000.");
                
        }
        
        /**
         * Annual Interest Rate
         */
        float annualInterest = 0.0f;
        while(true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();

            if (annualInterest > 0.0f && annualInterest < 30.0f) {
                break;
            }

            System.out.println("Enter a value greater than 0 and less than or equal to 30");
                
        }

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        /**
         * Period
         */
        byte period = 0;
        while(true) {
            
            System.out.print("Period (Years): ");
            scanner.nextByte();

            if (period > 0 && period <= 30) {
                break;
            }

            System.out.println("Enter a value between 1 and 30");
                
        }

        /**
         * Calculations
         */
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Mortgage: " + mortgageFormatted);

        scanner.close();
    }

}
