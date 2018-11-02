package com.cheeryhu.java.lockDemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentranLockLower {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    volatile boolean update = true;

    public void processData(){
        lock.readLock().lock();
        if(!update){
            //必须先释放读锁
           lock.readLock().unlock();
           // 锁降级从写锁获取到开始
            lock.writeLock().lock();
            try{
                if(!update){
                    // 准备数据的流程（略）
                    update = true;
                }
                lock.readLock().lock();
            }finally {
                lock.writeLock().unlock();
            }
            // 锁降级完成，写锁降级为读锁
        }
        try{
            // 使用数据的流程（略）
        }finally {
            lock.readLock().unlock();
        }
    }
}
