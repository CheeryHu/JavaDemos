package com.cheeryhu.java.thread.KFC;

public class Customers extends Thread{

    KFC kfc;

    public Customers(KFC kfc, String name){
        this.kfc = kfc;
        setName(name);
    }

    @Override
    public void run() {
        int size = (int) (Math.random()*5);
        while (true){
            kfc.consu(size);
        }
    }
}
