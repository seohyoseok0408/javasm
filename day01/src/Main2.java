public class Main2 {
    public static void main(String[] args) {
        // 실수는 기본이 double이다.
        float f1 = 10.2F;
        float f2 = 10.2F;
        float f3 = f1 + f2;
        System.out.println(f3);

        double d1 = 10.2;
        int a = 10;
        int b = 3;
        double result = a*1.0/b;
        System.out.println(result);
        System.out.printf("%3.4f", result); // 찾아볼 것
    }
}
