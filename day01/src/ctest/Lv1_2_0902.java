package ctest;

import java.util.Arrays;
import java.util.Scanner;

public class Lv1_2_0902 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) answer += i;
        }
        return answer + n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Lv1_2_0902 sol = new Lv1_2_0902();
        sol.solution(input);
    }
}
