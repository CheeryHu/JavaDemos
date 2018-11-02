package com.cheeryhu.nativeTest;

public class DemoTest {

    float fun0(){
        byte i = 1;
        return i;
    }
    float fun1(){
        int i = 1;
        return i;
    }
    float fun2(){
        short i = 1;
        return i;
    }
    float fun3(){
        long i = 3;
        return i;
    }
//    float fun4(){
//        double i = 4;
//        return i;
//    }

    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args){
//        DemoTest d = new DemoTest();
//        d.change(d.str, d.ch);
//        System.out.println(d.str + " and ");
//        System.out.println(d.ch);

        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.println(var1.intValue());
        System.out.println(var1 == var2);
    }

    public static void doSomething(Integer integer){
        integer = new Integer(2);
    }

    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'g';
    }
}
