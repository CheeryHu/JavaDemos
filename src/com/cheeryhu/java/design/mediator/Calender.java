package com.cheeryhu.java.design.mediator;

public class Calender extends Colleague{
    @Override
    public void onEvent(Mediator mediator) {
          mediator.doEvent("calendar");
    }

    public void doCalendar(){
        System.out.println("doCalendar()");
    }
}
