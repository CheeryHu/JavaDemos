package com.cheeryhu.java.base;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test extends Thread {
    static HashMap<Integer, Integer> map = new HashMap<>(2);
    static AtomicInteger at = new AtomicInteger();

    @Override
    public void run() {
        while (at.get() < 100000){
            map.put(at.get(), at.get());
            at.incrementAndGet();
        }
    }

    public static void main(String[] args){
        Test t0 = new Test();
        Test t1 = new Test();
        Test t2 = new Test();
        Test t3 = new Test();
        Test t4 = new Test();
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
