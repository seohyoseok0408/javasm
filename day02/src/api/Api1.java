package api;

import java.util.Random;
import java.util.Scanner;

public class Api1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = 0;
        try {
            number = sc.nextInt();
        }catch (Exception e) {
            System.out.println("Invalid number.. Try again.");
            sc.close();
            return;
        }
        Random rand = new Random();
        int num = rand.nextInt(number) + 1; // 0 ~ 9
        System.out.println(num);
        sc.close();
    }
}