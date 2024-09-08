package inherit;

public class Manager extends Employee{
    // is-a 관계 성립 -> Manager is a Employee
    private double bonus;

    public Manager(int empNo, String name, double salary, double bonus) {
        super(empNo, name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Manager :" + super.empNo;
    }
}
