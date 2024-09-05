package oop3;

public class Car {
    private static final int BOOST_THRESHOLD = 100;
    private static final double BOOST_MULTIPLIER = 1.5; // 부스터 사용 시 속도 증가율 (50% 증가)
    private int serial;
    private String name;
    private String color;
    private int maxSpeed;
    private boolean isRunning;
    private int boostCnt;
    private int gage;
    private boolean isBoosting; // 부스터 사용 여부

    private Engine engine;

    public Car(int serial, String name, String color, int maxSpeed) {
        if (maxSpeed <= 0) throw new IllegalArgumentException("최대 속도는 0보다 커야 합니다.");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        this.serial = serial;
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.isRunning = false;
        this.boostCnt = 0;
        this.gage = 0;
        this.isBoosting = false;
        this.engine = new Engine(123, "goatEngine", "Legend");
    }

    public void drive(double distance, double speed) {
        if (!isRunning) {
            System.out.println("▶ 차량이 아직 정지 상태입니다. 엔진을 가동합니다.");
            engine.start();
            isRunning = true;
        }

        // 부스터 사용 시 속도 증가
        if (isBoosting) {
            speed *= BOOST_MULTIPLIER;
            if (speed > maxSpeed) {
                speed = maxSpeed; // 최대 속도를 넘지 않도록 제한
            }
            System.out.println("💥 부스터 사용 중! 속도가 증가합니다.");
        }

        double timeInSeconds = (distance / 1000) / speed * 3600;
        gage += distance / 10; // 10m 당 게이지 1 상승

        System.out.printf("🚗 %.2f초 동안 %.2fkm를 시속 %.2fkm로 주행했습니다.\n", timeInSeconds, distance / 1000, speed);
        if (gage >= BOOST_THRESHOLD) {
            gage -= BOOST_THRESHOLD;
            boostCnt++;
        }
        System.out.printf("현재 부스터 갯수: %d, 게이지: %d\n", boostCnt, gage);

        // 부스터가 끝나면 부스터 상태 해제
        if (isBoosting) {
            endBoost();
        }
    }

    public void stop(){
        if (isRunning) {
            System.out.println("🛑 차량을 정지합니다.");
            this.isRunning = false;
            engine.stop();
        } else {
            System.out.println("차량이 이미 정지 상태입니다.");
        }
    }

    public void useBoost() {
        if (boostCnt > 0) {
            System.out.println("💥 부스트 발동!!");
            this.boostCnt--;
            isBoosting = true; // 부스터 사용 상태로 설정
            System.out.printf("현재 부스터 갯수: %d, 게이지: %d\n", boostCnt, gage);
        } else {
            System.out.println("부스트가 없습니다.");
        }
    }

    private void endBoost() {
        isBoosting = false;
        System.out.println("⚡ 부스터가 종료되었습니다.");
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
