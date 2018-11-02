package com.cheeryhu.java.enumType;

public enum EnumDemo {

    FIRST{
        @Override
        public String getInfo() {
            return "FIRST TIME";
        }
    },
    SECOND{
        @Override
        public String getInfo() {
            return "SECOND TIME";
        }
    };

    public abstract String getInfo();

    public static void main(String[] args){
        System.out.println(EnumDemo.FIRST.getInfo());
    }
}
