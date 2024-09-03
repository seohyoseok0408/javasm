package control;

import java.util.Scanner;

public class Control4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter Command : ");
            String cmd = sc.nextLine();
            if(cmd.equals("q")) {
                System.out.println("Quit : ");
                break;
            } else if (cmd.equals("i")) {
                System.out.println("Insert : id");
                String id = sc.nextLine();
                System.out.println("Insert : password");
                String password = sc.nextLine();
                System.out.printf("Inserted : %s, %s\n", id, password);
            } else if (cmd.equals("s")) {
                System.out.println("Search : ");
            } else {
                System.out.println("Try again : ");
            }
        }
        sc.close();
    }
}
