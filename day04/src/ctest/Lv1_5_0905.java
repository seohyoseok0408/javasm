package ctest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_5_0905 {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!list.contains(numbers[i] + numbers[j])){
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }
        return list.stream().sorted().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {
        Lv1_5_0905 solution = new Lv1_5_0905();
        System.out.println(Arrays.toString(solution.solution(new int[]{1,2,3,4,5})));
    }
}
