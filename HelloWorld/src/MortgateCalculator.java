import java.text.NumberFormat;
import java.util.Scanner;

public class MortgateCalculator {
    public static void main(String[] args) {
        
        

        int principle = 0;
        float annualInterest = 0;
        byte years = 0;

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
        while(true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();

            if (annualInterest > 0.0f && annualInterest < 30.0f)
                break;
        

            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

        /**
         * Period
         */
        while(true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();

            if (years > 1 && years <= 30)
                break;

            System.out.println("Enter a value between 1 and 30"); 
        }

       
        double mortage = calculateMortgate(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Mortgage: " + mortgageFormatted);

        scanner.close();
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

}
