public class Main {

        public static void main(String[] args) {
            int baseSalery = 50_000;
            int extraHours = 10;
            int hourlyRate = 20;
    
            int wage = calculateWage(baseSalery, extraHours, hourlyRate);
            System.out.println(wage);
        }

        public static int calculateWage(
            int baseSalery,
            int extraHours,
            int hourlyRate
        ) {
           return baseSalery + (extraHours * hourlyRate);
        }
}

