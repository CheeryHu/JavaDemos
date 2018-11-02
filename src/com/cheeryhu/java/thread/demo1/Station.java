package com.cheeryhu.java.thread.demo1;

/**
 * 对同一个数量进行操作
 */
public class Station extends Thread{

    static int count = 20;

    static Object obj = "aa";

    public Station(String name){
        super(name);
    }

    @Override
    public void run() {
        while(count > 0){
            synchronized (obj){
               if(count > 0 ){
                   System.out.println(this.getName() + "卖出第" + count + "张票");
                   count--;
               }else{
                   System.out.println("saled out");
               }
            }

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args){
        Station s1 = new Station("窗口1");
        Station s2 = new Station("窗口2");
        s1.start();
        s2.start();
    }

}
