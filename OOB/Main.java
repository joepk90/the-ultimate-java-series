public class Main {

        public static void main(String[] args) {
            var employee = new Employee();
            employee.baseSalery = 50_000;
            employee.hourlyRate = 20;

            int wage = employee.calculateWage(10);
            
            System.out.println(wage);
        }
}

