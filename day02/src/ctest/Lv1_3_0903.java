package ctest;

import java.util.Scanner;

public class Lv1_3_0903 {
    public int solution(long num) {
        int answer = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;

            if (answer >= 500) return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lv1_3_0903 sol = new Lv1_3_0903();
        System.out.println(sol.solution(sc.nextInt()));
    }
}
