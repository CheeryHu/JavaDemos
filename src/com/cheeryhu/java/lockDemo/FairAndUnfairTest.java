package com.cheeryhu.java.lockDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {


    private static Lock fairLock = new ReentranLock2(true);
    private static Lock unfailLock = new ReentranLock2(false);

    public void fair(){
        testLock(fairLock);
    }

    public void unfair(){
        testLock(unfailLock);
    }

    public static void main(String[] args){
        FairAndUnfairTest f = new FairAndUnfairTest();
//        f.fair();
//        f.unfair();
    }

    private void testLock(Lock lock){
        //启动5个job
//        for(int i = 0; i < 5; i++){
//            new Job(lock).start();
//        }
    }

    private static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }
        @Override
        public void run(){
            //连续2次打印当前的Thread和等待队列中的Thread
//            System.out.println("Lock by[" + Thread.currentThread() + "]" + ",Waiting by " + ((ReentranLock2)lock).getQueuedThreads());
        }
    }



    private static class ReentranLock2 extends ReentrantLock{

        public ReentranLock2(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {

            List<Thread> arrayList = new ArrayList<>(getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
