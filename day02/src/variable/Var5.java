package variable;

public class Var5 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        /*
        s1과 s2는 주소가 같다. -> string pool에 있는 것을 재활용하기 때문이다.
        s3과 s4는 각각 새로 생성한 것이기에 주소가 다르다.
        s1, s2, s3, s4의 값은 모두 같다.
         */

        // 주소를 비교
        if (s1 == s2) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }

        // equals는 값을 비교하는 것
        if (s1.equals(s4)) {
            System.out.println("s1 equals s4");
        } else {
            System.out.println("s1 not equals s4");
        }
    }
}
