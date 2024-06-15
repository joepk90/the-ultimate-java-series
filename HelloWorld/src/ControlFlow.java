public class ControlFlow {
    
    public static void main(String[] args) {
        // ControlFlow.comparisonOperators();
        // ControlFlow.logicalOperators();
        ControlFlow.ifStatements();
    }

    public static void comparisonOperators() {
        int x = 1;
        int y = 1;
        System.out.println(x == y); // true
        System.out.println(x != y); // false
        System.out.println(x > y); // false
        System.out.println(x >= y); // true
        System.out.println(x < y); // false
        System.out.println(x <= y); // true
    }

    public static void logicalOperators() {
        int temporature = 22;
        boolean isWarm = temporature > 20 && temporature < 30;
        System.out.println(isWarm); // true

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        System.out.println(isEligible); // true
    }

    public static void ifStatements() {
        int temp = 32;

        if (temp > 30) {
            System.out.println("It's a hot day");
            System.out.println("Drink water");
        }
        // curley braces are only required if there are multiple statements
        else if (temp > 20)
            System.out.println("Beautiful day");
        else
            System.out.println("Cold day");
    }
}
