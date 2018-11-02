package com.cheeryhu.java.thread.rabbitQuestion;

public class LetOneStop implements Calltoback {

    Animal an;

    public LetOneStop(Animal an){
        this.an = an;
    }

    @Override
    public void win() {
        an.stop();
    }
}
