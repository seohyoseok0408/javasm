package ctest;

public class Lv1_2_0904 {
    public int solution(int[] number) {
        int answer = 0;
        for (int i=0; i<number.length;i++) {
            for (int j =i+1; j<number.length;j++) {
                for (int k=j+1; k<number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Lv1_2_0904 solution = new Lv1_2_0904();
        System.out.println(solution.solution(new int[]{1,2,3,3,-3}));

    }
}
