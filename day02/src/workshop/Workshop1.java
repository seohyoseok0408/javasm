package workshop;

import java.util.Scanner;

public class Workshop1 {
    public static void main(String[] args) {
        int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int min = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d번째 숫자 입력 : ", i+1);
            arr[i] = sc.nextInt();
            for (int j =0; j<i; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("중복되는 숫자입니다. 다시 입력하세요");
                    i--;
                }
            }
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.printf("max : %d, min : %d", max, min);
    }
}

