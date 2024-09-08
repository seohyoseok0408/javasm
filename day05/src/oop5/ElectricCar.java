package oop5;

public class ElectricCar extends Car {
    private int batteryCapacity;
    private String chargingType;

    public ElectricCar(String id, String name, String color, int targetSpeed, int boostSpeed, Engine engine, int batteryCapacity, String chargingType) {
        super(id, name, color, targetSpeed, boostSpeed, engine);
        this.batteryCapacity = batteryCapacity;
        this.chargingType = chargingType;
    }

    @Override
    public double getFuelEfficiency() {
        return batteryCapacity * 1.5; // 배터리 용량에 따른 전기 효율성
    }

    @Override
    public double getRefuelTime() {
        return chargingType.equals("Fast") ? 1.5 : 5.0; // 충전 시간
    }
}
