package com.cheeryhu.java.thread;

public class TestJoin extends Thread{
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            System.out.println(Thread.currentThread().getName() + "第" + i + "次运行");
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args){
        System.err.println("主线程开始运行");
        TestJoin tj = new TestJoin();
        tj.setName("线程1");
        try {
            long start = System.nanoTime();
            tj.start();
            tj.join();
            long end = System.nanoTime();
            System.out.println("耗时" + (end - start)/1000000 + "毫秒");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("主线程运行结束");
    }
}
