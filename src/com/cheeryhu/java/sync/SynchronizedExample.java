package com.cheeryhu.java.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {

    public void func1(){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args){
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
        // 调用同一个对象的同步代码块，输出结果为：0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9

        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
        // 调用不同对象的同步代码块，输出结果顺序不确定：可能为：0 1 2 3 4 5 6 7 8 0 9 1 2 3 4 5 6 7 8 9

    }
}
