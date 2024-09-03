package ctest;

import java.util.Arrays;
import java.util.Scanner;

public class Lv1_1_0902 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n]; // n개의 요소를 가진 배열 생성
        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i + 1); // x의 배수를 배열에 추가
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Numbers x and n (e.g., 2 3):");
        String input = sc.nextLine(); // 한 줄로 입력 받기
        String[] inputs = input.split(","); // 공백 기준으로 나누기

        int x = Integer.parseInt(inputs[0]); // 첫 번째 값을 x로 변환
        int n = Integer.parseInt(inputs[1]); // 두 번째 값을 n으로 변환

        Lv1_1_0902 sol = new Lv1_1_0902();
        long[] result = sol.solution(x, n);
        System.out.println(Arrays.toString(result));
    }
}
