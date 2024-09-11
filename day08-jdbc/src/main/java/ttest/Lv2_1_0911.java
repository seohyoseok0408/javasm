package ttest;

import java.util.Arrays;

public class Lv2_1_0911 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i=0; i < d.length; i++) {
            if(budget < d[i]) {
                break;
            }
            budget -= d[i];
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Lv2_1_0911 solution= new Lv2_1_0911();
        System.out.println(solution.solution(new int[]{1,3,2,5,4}, 9));
        System.out.println(solution.solution(new int[]{2,2,3,3}, 10));
    }
}

