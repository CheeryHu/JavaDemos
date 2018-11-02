package com.cheeryhu.java.design.mediator;



public class ConcreteMediator extends Mediator{

    private Alarm alarm;
    private CoffeePot coffeePot;
    private Calender calendar;
    private Sprinkler sprinkler;

    public ConcreteMediator(Alarm alarm, CoffeePot coffeePot, Calender calendar, Sprinkler sprinkler) {
        this.alarm = alarm;
        this.coffeePot = coffeePot;
        this.calendar = calendar;
        this.sprinkler = sprinkler;
    }

    @Override
    public void doEvent(String eventType) {
        switch (eventType){
            case "alarm":
                doAlarmEvent();
                break;
            case "coffeePot":
                //
                break;
                //
            default:
                //
        }
    }

    public void doAlarmEvent(){
        alarm.doAlarm();
        coffeePot.doCoffeePot();
        calendar.doCalendar();
        sprinkler.doSprinkler();
    }

    public void doCoffeePotEvent(){
        //
    }
}
