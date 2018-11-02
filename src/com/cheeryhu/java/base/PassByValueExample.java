package com.cheeryhu.java.base;

public class PassByValueExample {
    public static void main(String[] args){
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress());
        func(dog);
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

    private static void func(Dog dog){
        dog = new Dog("B");
    }
}
