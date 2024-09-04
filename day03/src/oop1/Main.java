package oop1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("goat", "red"); // 객체 생성
        Car car2 = new Car();

        System.out.println(car); // toString 호출임. 재정의 안해놨으면 주소값 나오겠지

        car.go();
        car.brake();
    }
}
