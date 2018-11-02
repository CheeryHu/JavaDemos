package com.cheeryhu.java.lockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUseCase {
    public void test(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        }finally {
            lock.unlock();
        }
    }
}
