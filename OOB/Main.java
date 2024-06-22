public class Main {

        public static void main(String[] args) {
            // Main.employeeClassUsage();
            Main.InheritanceExample();
        }

        public static void employeeClassUsage() {
            var employee = new Employee(50_000, 20);
            Employee.printNumberOfEmployees();

            int wage = employee.calculateWage(10);
            System.out.println(wage);
        }

        public static void InheritanceExample() {
            var control = new UIControl();
            control.disable();
            System.out.println(control.isEnabled());
        }

        // reducing coupling
        public static void initialiseBrowser(String[] args) {
            var browser = new Browser();

            // because every method is private ( except navigate) coupling is reduced
            // as there is only one method which can be accessed from the outside
            browser.navigate("");
        }
}

