public class Employee {
    private int baseSalery;
    private int hourlyRate;



    // example of constructor overloading (making some arguments optional)
    public Employee(int baseSalery) {
        this(baseSalery, 0);

        // these lines are the same using the this method above
        // this.setBaseSalary(baseSalery);
        // this.setHourlyRate(0);
    }

    public Employee(int baseSalery, int hourlyRate) {
        this.setBaseSalary(baseSalery);
        this.setHourlyRate(hourlyRate);;
    }

    public int calculateWage(int extraHours) {
        return baseSalery + (hourlyRate & extraHours);
    }

    // example of method overloading (similar to setting default arguments values)
    public int calculateWage() {
        return calculateWage(0); 
    }

    private void setBaseSalary(int baseSalery) {
        if (baseSalery <= 0)
            throw new IllegalArgumentException("Base Salary cannot be 0 or less");

        this.baseSalery = baseSalery;
    }

    private int getBaseSalary() {
        return baseSalery;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly Rate cannot be 0 or negative");

        this.hourlyRate = hourlyRate;
    }

    private int getHourlyRate() {
        return hourlyRate;
    }
}