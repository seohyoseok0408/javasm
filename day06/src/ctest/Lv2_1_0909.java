package ctest;

public class Lv2_1_0909 {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i);
            if (temp == '(') {
                cnt++;
            } else if (temp == ')') {
                cnt--;
            }
            if (cnt < 0) {
                flag = false;
            }
        }
        if (flag) {
            if (cnt == 0) {
                answer = true;
            }
        } else {
            answer = false;
        }
        if (cnt > 0) answer = false;
        return answer;
    }

    public static void main(String[] args) {
        Lv2_1_0909 solution = new Lv2_1_0909();
        System.out.println(solution.solution("()()"));
        System.out.println(solution.solution("(())()"));
        System.out.println(solution.solution(")()("));
        System.out.println(solution.solution("(()("));

    }
}
