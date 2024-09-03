public class Main {
    public static void main(String[] args) {
        int a = 30000000;

        byte b1 = (byte)200;
        System.out.println(b1); // -56

        byte num1 = (byte)100;
        byte num2 = (byte)100;
        byte num3 = (byte) (num1 + num2);
        System.out.println(num3); // -56

        long num4 = 3000000000L; // L을 꼭 표기 (쩡수형의 기본은 int -> 에러 발생)

        long num5 = 15000000000L + 15000000000L;
        System.out.println(num5);

        int i1 = 1500000000;
        int i2 = 1500000000;
        long result = i1*1L + i2*1L;
        System.out.println(result);

    }
}