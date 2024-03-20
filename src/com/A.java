package com;

class Account {

    private double balance;

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        for (int i = 0; i < 10000; i++) {
            this.balance++;
        }
    }
}

public class A {

    public static void main(String[] args) {
        Account account = new Account();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                account.setBalance(100000);
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Balance :" + account.getBalance());
            }
        });
        t.start();
        t1.start();
    }
}
