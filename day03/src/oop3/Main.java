package oop3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            printGameTitle();

            // DB에서 가져온 데이터라 가정
            String name = "person";
            int level = 22;

            // 여러 차량을 준비
            Car[] cars = {
                    new Car(1, "Speedster", "Red", 200),
                    new Car(2, "Thunder", "Blue", 250),
                    new Car(3, "Flash", "Yellow", 300)
            };

            // 차량 선택
            Car selectedCar = getUserCarSelection(sc, cars);
            if (selectedCar == null) {
                System.out.println("잘못된 차량 선택입니다. 프로그램을 종료합니다.");
                return;
            }

            // Driver 생성
            Driver driver = new Driver(name, level);
            System.out.println("\n★★★ 게임을 시작합니다! ★★★");
            System.out.println("g : 주행 | s: 정지 | b: 부스트 사용 | q: 나가기");
            printSeparator();

            // 게임 루프
            gameLoop(sc, driver, selectedCar);
        } finally {
            sc.close(); // 자원 해제
        }
    }

    private static Car getUserCarSelection(Scanner sc, Car[] cars) {
        System.out.println("차량을 선택하세요: ");
        for (int i = 0; i < cars.length; i++) {
            System.out.println((i + 1) + ". " + cars[i].getName() + " (" + cars[i].getColor() + ")");
        }

        try {
            int carChoice = sc.nextInt() - 1;
            if (carChoice >= 0 && carChoice < cars.length) {
                return cars[carChoice];
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            sc.next(); // 입력 버퍼 초기화
        }
        return null; // 잘못된 선택
    }

    private static void gameLoop(Scanner sc, Driver driver, Car selectedCar) {
        while (true) {
            System.out.print("\n▶ 명령을 입력하세요: ");
            String input = sc.next();
            if (input.equals("q")) {
                break;
            } else if (input.equals("g")) {
                handleDrive(sc, driver, selectedCar);
            } else if (input.equals("s")) {
                driver.stopCar(selectedCar);
            } else if (input.equals("b")) {
                driver.useBoost(selectedCar);
            } else {
                System.out.println("잘못된 명령어입니다. 다시 입력하세요.");
            }
        }

        System.out.println("\n★★★ 게임 종료 ★★★");
    }

    private static void handleDrive(Scanner sc, Driver driver, Car selectedCar) {
        try {
            System.out.print("몇 미터를 주행할 것인가요? : ");
            double distance = sc.nextDouble();
            System.out.print("몇 km/h로 주행할 것인가요? : ");
            double speed = sc.nextDouble();
            driver.drive(selectedCar, distance, speed);
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            sc.next(); // 입력 버퍼 초기화
        }
    }

    public static void printSeparator() {
        System.out.println("=====================================");
    }

    public static void printGameTitle() {
        System.out.println("*************************************");
        System.out.println("*******       카트라이더       *********");
        System.out.println("*************************************");
    }
}
