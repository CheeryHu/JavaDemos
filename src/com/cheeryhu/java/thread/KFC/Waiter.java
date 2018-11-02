package com.cheeryhu.java.thread.KFC;

public class Waiter extends Thread{

    KFC kfc;

    public Waiter(KFC kfc, String name){
        this.kfc = kfc;
        setName(name);
    }

    @Override
    public void run() {
        int size = (int) (Math.random() * 5) + 5;//每次生产的数量
        while (true) {
            kfc.prod(size);
        }
    }
}
