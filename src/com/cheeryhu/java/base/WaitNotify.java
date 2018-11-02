package com.cheeryhu.java.base;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args){
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        sleep(1000);

        Thread notifyThread = new Thread(new Notify(), "notifyThread");
        notifyThread.start();
    }

    private static void sleep(int milliTime) {
        try {
            Thread.sleep(milliTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            // 加锁，拥有lock的monitor
            synchronized (lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + " flag is true " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        // 条件不满足时，继续等待，同时释放lock的锁，进入对象的等待队列，进入等待状态
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 条件满足，完成工作
                System.out.println(Thread.currentThread() + " flag is false " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            // 加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock. notify " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁
                // 直到当前线程释放了lock锁后，waitThread才能从wait方法中返回
                lock.notifyAll();
                flag = false;
                sleep(5000);
            }
            // 再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                sleep(5000);
            }
        }
    }
}
