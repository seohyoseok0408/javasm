package bank;

import bank.exception.InException;
import bank.exception.ZeroException;

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("111", 1000.0);

        System.out.println(account1);

        account1.deposit(5000);
        System.out.println(account1);

        try {
            account1.withdraw(-300);
        } catch (ZeroException e) {
            System.out.println(e.getMessage());
        } catch (InException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(account1);

    }
}
