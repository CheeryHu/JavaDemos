package com.cheeryhu.java.base;

public class BasicTypeTest {
    public static void main(String[] args){
//        func1();
//        fun2();
        long var = 1000;
    }

    private static void fun2() {
        short s = 1;
        s = (short)(s + 1);
        s+=1;
        System.out.println(s);
    }

    private static void func1() {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);
    }
}
