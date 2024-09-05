package oop2;

public class Main2 {
    public static void main(String[] args) {
        Car car = new Car("k1", "red", 55, 10);
        System.out.println(car);

        Engine engine = new Engine(100, 3000, "s1");
        car.setEngine(engine); // 자동차는 엔진을 보유하고 있는 형태 !!

        System.out.println(car);
    }
}
