public class Employee {
    public int baseSalery;
    public int hourlyRate;

    public int calculateWage(int extraHours) {
        return baseSalery + (hourlyRate & extraHours);
    }
}