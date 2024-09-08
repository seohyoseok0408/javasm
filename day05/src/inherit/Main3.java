package inherit;

public class Main3 {
    public static void main(String[] args) {
        Employee[] emps = new Employee[4];

        emps[0] = new Employee(100, "Jason", 1000);
        emps[1] = new Employee(101, "Ani", 1000);
        emps[2] = new Manager(102, "Tom", 1000, 500);
        emps[3] = new Manager(103, "Babe", 1000, 500);


        for (Employee e : emps) {
            System.out.println(e);
            System.out.println(e.getSalary());
            if (e instanceof Manager) {
                Manager m = (Manager) e; // 참조변수의 형변환
            }
        }
    }
}
