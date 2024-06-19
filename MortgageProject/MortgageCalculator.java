package MortgageProject;

public class MortgageCalculator {

    public static double calculateBalance(int principle, float annualInterest, int years, short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / MortgateCalculator.PERCENT / MortgateCalculator.MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MortgateCalculator.MONTHS_IN_YEAR);
    
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
            float monthlyInterest = annualInterest / MortgateCalculator.PERCENT / MortgateCalculator.MONTHS_IN_YEAR;
            short numberOfPayments = (short)(years * MortgateCalculator.MONTHS_IN_YEAR);
            
    
            double mortage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    
            return mortage;
    }
    
}
