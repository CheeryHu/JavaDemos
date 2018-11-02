package com.cheeryhu.java.base.innerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TalkingClock {

    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){

    }

    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(beep){
                //内部类既可以访问自身的数据域，也可以方位创建它的外围类对象的数据域
                //beep是外围类的数据域
                //内部类的对象总有一个隐式引用，指向其外围类对象(TalkingClock outer;outer.beep)
            }
        }

        //编译器为内部类添加的构造函数
//        public TimePrinter(TalkingClock talkingClock) {
//            outer = talkingClock;
//        }
    }
}
