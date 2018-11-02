package com.cheeryhu.java.thread.KFC;

public class MainClass {

    public static void main(String[] args){
        KFC kfc = new KFC();

        Customers c1 = new Customers(kfc, "customer1");
        Customers c2 = new Customers(kfc, "customer2");
        Customers c3 = new Customers(kfc, "customer3");
        Customers c4 = new Customers(kfc, "customer4");

        Waiter waiter1 = new Waiter(kfc,"waiter1");
        Waiter waiter2 = new Waiter(kfc,"waiter2");
        Waiter waiter3 = new Waiter(kfc,"waiter3");

        waiter1.start();
        waiter2.start();
        waiter3.start();

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
