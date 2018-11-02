package com.cheeryhu.java.thread.demo2;

public class PersonB extends Thread {
    Bank bank;

    public PersonB(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        while (Bank.money >= 200) {
            bank.ATM(200);
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
