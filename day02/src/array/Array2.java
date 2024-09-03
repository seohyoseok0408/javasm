package array;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        String s[] = new String[3];
        s[0] = "A";
        s[1] = "B";
        s[2] = "A";
        StringBuffer sb = new StringBuffer();
        for (String str : s) {
            sb.append(str);
        }
    }
}
/*
stack 영역에는 s배열의 주소가 들어감
그 주소가 나타내는 힙영역의 3곳은 다 String이기에 주소가 있음
그 주소는 spring pool을 가리킨다.
 */