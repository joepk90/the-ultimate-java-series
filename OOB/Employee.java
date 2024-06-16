public class Employee {
    private int baseSalery;
    public int hourlyRate;

    public int calculateWage(int extraHours) {
        return baseSalery + (hourlyRate & extraHours);
    }

    public void setBaseSalary(int baseSalery) {
        if (baseSalery <= 0)
            throw new IllegalArgumentException("Base Salary cannot be 0 or less");

        this.baseSalery = baseSalery;
    }

    public int getBaseSalary() {
        return baseSalery;
    }
}