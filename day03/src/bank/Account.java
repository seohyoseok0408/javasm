package bank;

import bank.exception.InException;
import bank.exception.ZeroException;

public class Account {
    private String accNo;
    private double balance;

    public Account() {}
    public Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() { // 잔액조회
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }

    // 입금과 출금
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws ZeroException, InException {
        if (amount < 0 ) {
            throw new ZeroException("Amount must be greater than or equal to 0"); // 예외를 직접 만들어서 처리
        }else if (amount > this.balance) {
            throw new InException("Insufficient balance"); // 상황에 따라서 예외가 각기 날라간다.
        }else {
            this.balance -= amount;
        }
    }
}
