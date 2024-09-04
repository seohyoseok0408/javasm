package oop2;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("K1", "black", 50, 10);
        try {
            car.addFuel(44);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(car);
        car.go(275);
        car.brake();
    }
}
