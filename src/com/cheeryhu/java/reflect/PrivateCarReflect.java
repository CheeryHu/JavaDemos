package com.cheeryhu.java.reflect;

import java.lang.reflect.Field;

public class PrivateCarReflect {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = PrivateCarReflect.class.getClassLoader();
        Class clazz = classLoader.loadClass("com.cheeryhu.java.reflect.PrivateCar");
        PrivateCar privateCar = (PrivateCar) clazz.newInstance();
        Field colorFiled = clazz.getField("color");

        colorFiled.setAccessible(true);
        colorFiled.set(privateCar, "红色");



    }
}
