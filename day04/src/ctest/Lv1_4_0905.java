package ctest;

public class Lv1_4_0905 {
    public int solution(String s) {
        String[] dic = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < dic.length; i++) {
            if (s.contains(dic[i])) {
                s = s.replace(dic[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Lv1_4_0905 solution = new Lv1_4_0905();
        System.out.println(solution.solution("one4seveneight"));

    }
}
