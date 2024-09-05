package ctest;

public class Lv1_3_0905 {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        if (s.length() % 2 == 0) {
            answer += arr[s.length()/2 -1];
            answer += arr[s.length()/2 ];
        } else {
            answer += arr[s.length()/2];
        }
        return answer;
    }

    public static void main(String[] args) {
        Lv1_3_0905 solution = new Lv1_3_0905();
        System.out.println(solution.solution("abcde"));

    }
}
