package MortgageProject;

import com.ultimatejavaseries.Main;

public class MortgageCalculator {
    private int principle;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principle, float annualInterest, byte years) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * Main.MONTHS_IN_YEAR);
    
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

    public double calculateMortgate(
        ) {
            float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;
            short numberOfPayments = (short)(years * Main.MONTHS_IN_YEAR);
            
    
            double mortage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    
            return mortage;
    }
    
    public short getYears() {
        return years;
    }

}
