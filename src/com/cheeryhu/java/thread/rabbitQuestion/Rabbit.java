package com.cheeryhu.java.thread.rabbitQuestion;

public class Rabbit extends Animal{

    public Rabbit(){
        setName("兔子");
    }

    /**
     * 兔子每秒0.5米的速度，每跑2米休息1秒
     */
    @Override
    public void running() {
        double dis = 0.5;
        length -= dis;
        if(length <= 0){
            length = 0;
            System.out.println("兔子获得了胜利");
            if(calltoback != null){
                calltoback.win();
            }
        }
        System.out.println("兔子跑了" + dis + "米，距离终点还有" + (int)length + "米");
        if(length % 2 == 0){
            try {
                sleep(1000l);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
