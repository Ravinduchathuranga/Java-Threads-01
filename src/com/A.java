package com;

class Account {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

public class A {

    public static void main(String[] args) {
        Account account = new Account();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                account.setBalance(2000);
            }
        });
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(account.getBalance());
            }
        });
        
        t.start();
        t1.start();
    }
}
