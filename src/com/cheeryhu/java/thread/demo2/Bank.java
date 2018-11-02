package com.cheeryhu.java.thread.demo2;

public class Bank {
    static int money = 1000;

    public void Counter(int money){
        Bank.money -= money;
        System.out.println("A取了" + money + "元钱");
    }

    public synchronized void ATM(int money){
        Bank.money -= money;
        System.out.println("B取了" + money + "元钱");
    }

}
