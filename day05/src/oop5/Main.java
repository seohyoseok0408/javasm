package oop5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 엔진 객체 생성
        Engine jiuEngine = new Engine("E001", "JIU", 300, "Gasoline");
        Engine xEngine = new Engine("E002", "X", 350, "Diesel");
        Engine v1Engine = new Engine("E003", "V1", 400, "Hybrid");
        Engine electricEngine = new Engine("E004", "E-Tech", 450, "Electric");

        // 각 차종에 맞는 차량 객체 생성
        Car car1 = new GasolineCar("C001", "Speedster", "Blue", 180, 300, jiuEngine);
        Car car2 = new DieselCar("C002", "Turbo", "Red", 200, 320, xEngine);
        Car car3 = new HybridCar("C003", "Stealth", "Black", 190, 310, v1Engine, 80, "Normal");
        Car car4 = new GasolineCar("C004", "Roadster", "Yellow", 170, 290, jiuEngine);
        Car car5 = new ElectricCar("C005", "Bullet", "Silver", 210, 330, electricEngine, 100, "Fast");

        // 운전자 객체 생성
        Driver driver = new Driver("RacerX", 5);
        System.out.println("Driver: " + driver.getNickname() + ", Level: " + driver.getLevel());

        // 차량 선택
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a car to drive (1-5): ");
        System.out.println("1. " + car1.getDetails());
        System.out.println("2. " + car2.getDetails());
        System.out.println("3. " + car3.getDetails());
        System.out.println("4. " + car4.getDetails());
        System.out.println("5. " + car5.getDetails());

        int choice = scanner.nextInt();
        scanner.nextLine();

        // 선택한 차량으로 설정
        switch (choice) {
            case 1 -> driver.selectCar(car1);
            case 2 -> driver.selectCar(car2);
            case 3 -> driver.selectCar(car3);
            case 4 -> driver.selectCar(car4);
            case 5 -> driver.selectCar(car5);
            default -> {
                System.out.println("Invalid choice. No car selected.");
                return;
            }
        }

        // 주행 시나리오
        System.out.println("\n--- Driving Scenario ---");
        driver.drive();

        // 부스터 사용 또는 종료
        while (true) {
            System.out.println("Press 'B' to use booster or 'Q' to quit:");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("B")) {
                driver.useBooster();
            } else if (input.equals("Q")) {
                break;
            } else {
                System.out.println("Invalid input. Please press 'B' to use booster or 'Q' to quit.");
            }
        }

        // 마지막 상태 출력
        System.out.println("\n--- Final Status ---");
        if (driver.getSelectedCar() != null) {
            System.out.println(driver.getSelectedCar().getDetails());
        }
    }
}
