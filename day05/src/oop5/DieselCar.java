package oop5;

public class DieselCar extends Car {
    public DieselCar(String id, String name, String color, int targetSpeed, int boostSpeed, Engine engine) {
        super(id, name, color, targetSpeed, boostSpeed, engine);
    }

    @Override
    public double getFuelEfficiency() {
        return 15.0; // 디젤차는 높은 연비
    }

    @Override
    public double getRefuelTime() {
        return 4.0; // 주유 시간
    }
}
