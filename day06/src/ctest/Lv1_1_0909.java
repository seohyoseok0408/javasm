package ctest;

public class Lv1_1_0909 {
    public String solution(String nickname) {
        String answer = "";
        for(int i=0; i<nickname.length(); i++){
            if(nickname.charAt(i) == 'l'){
                answer += "I";
            }
            else if(nickname.charAt(i) == 'w'){
                answer += "vv";
            }
            else if(nickname.charAt(i) == 'W'){
                answer += "VV";
            }
            else if(nickname.charAt(i) == 'O'){
                answer += "0";
            }
            else{
                answer += nickname.charAt(i);
            }
        }
        while(answer.length() <= 3){
            answer += "o";

        }
        if(answer.length() > 8){
            answer = answer.substring(0, 8);
        }
        return answer;
    }

    public static void main(String[] args) {
        Lv1_1_0909 solution = new Lv1_1_0909();
        System.out.println(solution.solution("WORLDworld"));
        System.out.println(solution.solution("GO"));
    }
}
