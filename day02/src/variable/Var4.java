package variable;

public class Var4 {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        int result = a + b;
        System.out.println(result);

        String str = "Hello"; // String pool 영역이 만들어 진다.
        System.out.println(str);
        String str2 = new String("Hello");
        System.out.println(str2);

        String str3 = "Hello";
        System.out.println(str3); // str이랑 같은 주소 가짐. 재활용

        String str4 = "Hello";
        System.out.println(str4);
    }
}
