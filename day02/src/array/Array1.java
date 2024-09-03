package array;

import java.util.Arrays;
import java.util.Random;

// 자바는 배열을 잘 쓰지 않는다.
public class Array1 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        Random random = new Random();
        for(int i=0; i<arr.length; i++) {
            arr[i] = random.nextInt(100)+1;
        }
        System.out.println(arr); // [I@36baf30c
        System.out.println(Arrays.toString(arr));

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

        for(int n:arr){ // 향상된 for문
            System.out.println(n);
        }
    }
}
