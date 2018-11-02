package com.cheeryhu.java.base;

public class Dog {
    String name;
    Dog(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    String getObjectAddress(){
        return super.toString();
    }
}
