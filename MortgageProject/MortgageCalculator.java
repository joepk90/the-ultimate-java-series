package MortgageProject;

public class MortgageCalculator {
    public final static byte PERCENT = 100;
    public final static byte MONTHS_IN_YEAR = 12;

    private int principle;
    private float annualInterest;
    private byte years;
   

    public MortgageCalculator(int principle, float annualInterest, byte years) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();
    
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
            float monthlyInterest = getMonthlyInterest();
            short numberOfPayments = getNumberOfPayments();
            
    
            double mortage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    
            return mortage;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short)(years * MONTHS_IN_YEAR);
    }
    
    public short getYears() {
        return years;
    }

}
