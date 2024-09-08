package ctest;

import java.util.Arrays;

public class Lv1_1_0906 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i=0; i<n; i++) {
            // 9(1001), 11(1011) -> 11(1001)
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            temp = "0".repeat(n - temp.length()) + temp;
            answer[i] = temp;
        }
        for (int j=0; j<n; j++) {
            answer[j]  = answer[j].replace("1", "#");
            answer[j]  = answer[j].replace("0", " ");
        }
        return answer;
    }
    public static void main(String[] args) {
        Lv1_1_0906 solution = new Lv1_1_0906();
        System.out.println(Arrays.toString(solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }
}
