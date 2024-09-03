package ctest;

import java.util.Scanner;

public class Lv1_1_0903 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 1 ) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Lv1_1_0903 sol = new Lv1_1_0903();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(sol.solution(input));
    }
}
