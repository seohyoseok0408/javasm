package oop3;

import java.util.Scanner;

public class Driver {
    private String nickName;
    private int level;

    public Driver(String nickName, int level) {
        this.nickName = nickName;
        this.level = level;
    }

    public void drive(Car car, double distance, double speed) {
        System.out.println(nickName + "님이 " + car.getName() + " 차량을 운전합니다.");

        if (speed > car.getMaxSpeed()) {
            System.out.println("⚠ 속도가 차량의 최대 속도를 초과합니다. 최대 속도로 설정합니다.");
            speed = car.getMaxSpeed();
        }
        car.drive(distance, speed);
    }

    public void stopCar(Car car) {
        System.out.println(nickName + "님이 차량을 정지합니다.");
        car.stop();
    }

    public void useBoost(Car car) {
        System.out.println(nickName + "님이 부스트를 사용합니다.");
        car.useBoost();
    }


}
