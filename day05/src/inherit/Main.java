package inherit;

public class Main{
    public static void main(String[] args) {
        Employee emp = new Employee(100, "James", 1000);
        Manager mgr = new Manager(101, "Tom", 1000, 100);

        System.out.println(emp);
        System.out.println(mgr);
    }
}
