package ctest;

public class Lv1_2_0910 {
    public int solution(String s) {
        int answer = 0;
        String copy = s;

        for (int i = 0; i < s.length(); i++) {
            if (isValid(copy)) {
                answer++;
            }
            // 문자열 회전
            copy = copy.substring(1) + copy.charAt(0);
        }

        return answer;
    }

    // 괄호의 중첩이 올바른지 확인하는 메서드
    private boolean isValid(String s) {
        int[] arr = {0, 0, 0}; // 대괄호, 중괄호, 소괄호 개수 저장
        int openCount = 0; // 열린 괄호 수를 추적
        boolean flag = true;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (c == '[') {
                arr[0]++;
                openCount++;
            } else if (c == ']') {
                if (arr[0] > 0) {
                    arr[0]--;
                    openCount--;
                } else {
                    flag = false;
                    break;
                }
            } else if (c == '{') {
                arr[1]++;
                openCount++;
            } else if (c == '}') {
                if (arr[1] > 0) {
                    arr[1]--;
                    openCount--;
                } else {
                    flag = false;
                    break;
                }
            } else if (c == '(') {
                arr[2]++;
                openCount++;
            } else if (c == ')') {
                if (arr[2] > 0) {
                    arr[2]--;
                    openCount--;
                } else {
                    flag = false;
                    break;
                }
            }
        }

        // 모든 괄호가 짝을 이루고 있고, 열린 괄호가 모두 닫혔을 때 true
        return flag && openCount == 0;
    }

    public static void main(String[] args) {
        Lv1_2_0910 solution = new Lv1_2_0910();
        System.out.println("result :" + solution.solution("[](){}")); // 3
        System.out.println("result :" + solution.solution("}]()[{")); // 2
        System.out.println("result :" + solution.solution("[)(]"));   // 0
        System.out.println("result :" + solution.solution("}}}"));    // 0
        System.out.println("result :" + solution.solution("{(})"));   // 0 (올바르게 0이 출력됩니다)
    }
}
