package com.cheeryhu.java.thread.rabbitQuestion;

/**
 *
 * 龟兔赛跑：20米     //只要为了看到效果，所有距离缩短了
 *
 *  要求：
 *
 * 1.兔子每秒0.5米的速度，每跑2米休息10秒，
 *
 * 2.乌龟每秒跑0.1米，不休息
 *
 * 3.其中一个跑到终点后另一个不跑了！
 *
 * 程序设计思路：
 *
 * 1.创建一个Animal动物类，继承Thread，编写一个running抽象方法，重写run方法，把running方法在run方法里面调用。
 *
 * 2.创建Rabbit兔子类和Tortoise乌龟类，继承动物类
 *
 * 3.两个子类重写running方法
 *
 * 4.本题的第3个要求涉及到线程回调。需要在动物类创建一个回调接口，创建一个回调对象
 */
public abstract class Animal extends Thread{

    public double length = 20;

    public abstract void running();

    @Override
    public void run() {
        super.run();
        while (length > 0){
            running();
        }
    }

    public Calltoback calltoback;
}

interface Calltoback{
    public void win();
}
