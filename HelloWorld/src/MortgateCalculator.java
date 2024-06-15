import java.text.NumberFormat;
import java.util.Scanner;

public class MortgateCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principle = 0;
        float monthlyInterest = 0;
        
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

         /**
         * Principle (Loan)
         */
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
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }

            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

        /**
         * Period
         */
        while(true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();

            if (years > 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }

            System.out.println("Enter a value between 1 and 30"); 
        }

        /**
         * Calculations
         */
        double mortage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Mortgage: " + mortgageFormatted);

        scanner.close();
    }

}
