import java.text.NumberFormat;
import java.util.Scanner;

public class MortgateCalculator {
    public static void main(String[] args) {
        MortgateCalculator.calculateMortgate();
    }

    public static long getPrinciple(Scanner scanner) {
        System.out.print("Principle: ");
        long principle = scanner.nextLong();

        return principle;
    }

    public static int getPeriod(Scanner scanner) {
        System.out.print("Period (years): ");
        int period = scanner.nextInt();

        return period;
    }

    public static float getAnnualInterestRate(Scanner scanner) {
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();

        return annualInterestRate;
    }

    public static void calculateMortgate() {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        long principle = MortgateCalculator.getPrinciple(scanner);
        float annualInterestRate = MortgateCalculator.getAnnualInterestRate(scanner);
        int period = MortgateCalculator.getPeriod(scanner);

        // calculate mortage
        float monthlyInterestRate = (annualInterestRate / PERCENT)
                / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortage = principle * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);

        System.out.println("Mortgage: " + mortgageFormatted);

        scanner.close();
    }

}
