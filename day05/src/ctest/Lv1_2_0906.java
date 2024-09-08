package ctest;

import java.util.*;

public class Lv1_2_0906 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> arr  = new ArrayList<Integer>();
        for (int i = 0; i < score.length; i++) {
            if (arr.size() < k) {
                arr.add(score[i]);
            } else {
                int min = arr.get(0); // arr 중 최소값
                if (min < score[i]) {
                    arr.remove(0);
                    arr.add(score[i]);
                }
            }
            Collections.sort(arr);
            answer[i] = arr.get(0);
        }
        return answer;
    }

    public static void main(String[] args) {
        Lv1_2_0906 solution = new Lv1_2_0906();
        System.out.println(Arrays.toString(solution.solution(3, new int[] { 10, 100, 20, 150, 1, 100, 200})));

    }


}
