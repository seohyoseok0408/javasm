package ttest;

public class Lv1_1_0911 {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i= 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        answer = arr[n];
        return answer;
    }

    public static void main(String[] args) {
        Lv1_1_0911 l = new Lv1_1_0911();
        System.out.println(l.solution(3));
        System.out.println(l.solution(5));
        System.out.println(l.solution(10));

    }
}

