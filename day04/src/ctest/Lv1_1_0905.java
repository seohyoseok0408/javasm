package ctest;

public class Lv1_1_0905 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long temp = 0;
        for (int i=1; i<=count;i++){
            temp += price * i;
        }
        answer = money - temp;
        if(answer < 0){
            answer *= -1;
        }else{
            answer = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        Lv1_1_0905 solution = new Lv1_1_0905();
        System.out.println(solution.solution(3, 20, 4));
    }
}
