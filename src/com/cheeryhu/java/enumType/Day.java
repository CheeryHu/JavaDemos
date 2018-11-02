package com.cheeryhu.java.enumType;

public enum Day {

    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private final String desc;

    private Day(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args){
//        for(Day day: Day.values()){
//            System.out.println("name:" + day.name() + ",desc" + day.getDesc());
//        }

        String today = "星期六";

        if (today.equals(MONDAY.getDesc())) {
            System.out.println("doNothing!");
        } else {
            System.out.println("work!");
        }


    }
}
