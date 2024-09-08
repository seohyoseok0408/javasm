package inherit2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10, 10, 54);
        shapes[1] = new Rectangle(20, 20, 100, 200);
        shapes[2] = new Triangle(30, 30, 300, 400);

        for (Shape s : shapes) {
            System.out.println(s);
            System.out.println(s.getArea());
            System.out.println(s.getCircum());
            System.out.println("----------------------------------");
        }

    }
}
/*

자동차 추상클래스
그것을 드라이버가 다양하게 선택해서 가질 수 있게끔 구성해서 프로그램 ㄱ


 */