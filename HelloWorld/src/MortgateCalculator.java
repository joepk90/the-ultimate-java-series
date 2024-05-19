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
        Scanner scanner = new Scanner(System.in);
        long principle = MortgateCalculator.getPrinciple(scanner);
        float annualInterestRate = MortgateCalculator.getAnnualInterestRate(scanner);
        int period = MortgateCalculator.getPeriod(scanner);

        // calculate mortage
        float monthlyInterestRate = (annualInterestRate / 100) / 12;
        int totalMonths = period * 12;
        float repaymentAmount = principle * (monthlyInterestRate * totalMonths);

        // EQUATION NOT QUITE RIGHT...

        System.out.println("Repayment amount: " + repaymentAmount);

        scanner.close();
    }

}
