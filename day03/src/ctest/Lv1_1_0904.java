package ctest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Lv1_1_0904 {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (i==0) stack.push(arr[i]);
            else if (stack.peek() != arr[i]) stack.push(arr[i]);
        }

        answer = new int[stack.size()];
        for(int i= stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}
