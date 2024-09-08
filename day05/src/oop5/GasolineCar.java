package oop5;
public class GasolineCar extends Car {
    private boolean turbocharged;

    public GasolineCar(String id, String name, String color, int targetSpeed, int boostSpeed, Engine engine) {
        super(id, name, color, targetSpeed, boostSpeed, engine);
        this.turbocharged = false; // 기본적으로 터보차저가 없는 차량
    }

    public GasolineCar(String id, String name, String color, int targetSpeed, int boostSpeed, Engine engine, boolean turbocharged) {
        super(id, name, color, targetSpeed, boostSpeed, engine);
        this.turbocharged = turbocharged; // 터보차저 유무를 설정할 수 있는 생성자
    }

    @Override
    public double getFuelEfficiency() {
        // 터보차저가 있으면 연비가 더 나빠짐
        return turbocharged ? 8.0 : 12.0;
    }

    @Override
    public double getRefuelTime() {
        return 3.0; // 주유 시간 3분
    }

    @Override
    public String getDetails() {
        return super.getDetails() + (turbocharged ? ", Turbocharged" : ", Non-Turbocharged");
    }
}
