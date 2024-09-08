package oop5;

public class HybridCar extends Car {
    private int batteryCapacity;
    private String chargingType;

    public HybridCar(String id, String name, String color, int targetSpeed, int boostSpeed, Engine engine, int batteryCapacity, String chargingType) {
        super(id, name, color, targetSpeed, boostSpeed, engine);
        this.batteryCapacity = batteryCapacity;
        this.chargingType = chargingType;
    }

    @Override
    public double getFuelEfficiency() {
        return 20.0 + (batteryCapacity * 0.1); // 기본 연비 + 배터리 용량에 따른 효율성
    }

    @Override
    public double getRefuelTime() {
        return chargingType.equals("Fast") ? 2.0 : 5.0; // 충전 시간
    }
}
