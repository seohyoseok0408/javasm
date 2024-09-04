package oop1;

public class Main1 {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("K1", "red");
        Car car3 = new Car(123, "K2", "blue");

        car2.setColor("blue");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}
