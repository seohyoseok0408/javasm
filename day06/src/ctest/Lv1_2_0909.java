package ctest;

public class Lv1_2_0909 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int temp = 0;
        for (int i=1; i<=number; i++) {
            temp = checkCnt(i);
            if (temp <= limit) {
                answer += temp;
            } else if (temp > limit) {
                answer += power;
            }
        }
        return answer;
    }
    public int checkCnt(int n) {
        int num = n;

        int cnt = 0;
        for (int i=1; i * i <= num; i++) {
            if (i * i == num) cnt++;
            else if (num % i == 0) cnt += 2;
        }
        return cnt;
    }
    public static void main(String[] args) {
        Lv1_2_0909 solution = new Lv1_2_0909();
        System.out.println(solution.solution(5, 3, 2));
        System.out.println(solution.solution(10, 3, 2));
    }
}
