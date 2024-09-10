package ctest;

public class Lv1_1_0910 {
    public int solution(String dartResult) { //정답참고함
        int answer = 0;
        int pre = 0; // 이전 라운드 점수
        int cur = 0; // 현재 라운드 점수

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c == '1' && dartResult.charAt(i + 1) == '0') {
                answer += pre;
                pre = cur;
                cur = 10;
                i++; // '0'부분 건너뛰기'
            } else if (c >= '1' && c <= '9') {
                answer += pre;
                pre = cur;
                cur = c - '0'; // '0'의 아스키 코드값을 빼서 실제 숫자로 바꿈
            }

            if (c == 'S') {
            } else if (c == 'D') {
                cur = cur * cur;
            } else if (c == 'T') {
                cur = cur * cur * cur;
            }

            if (c == '*') {
                pre *= 2;
                cur *= 2; // 스타상
            } else if (c == '#') {
                cur *= -1; // 아차상
            }
        }
        answer += pre + cur;
        return answer;
    }

    public static void main(String[] args) {
        Lv1_1_0910 solution = new Lv1_1_0910();
        System.out.println(solution.solution("1S2D*3T")); // 37
        System.out.println(solution.solution("1D2S#10S")); // 9
    }
}
