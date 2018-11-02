package com.cheeryhu.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Car car = initByDefaultConst();
        car.introduce();
        Car car2 = initByConst();
        car2.introduce();
    }

    public static Car initByDefaultConst() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.cheeryhu.java.reflect.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car) cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗C");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    public static Car initByConst() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Class clazz = classLoader.loadClass("com.cheeryhu.java.reflect.Car");
        Constructor cons = clazz.getDeclaredConstructor(String.class, String.class, int.class);
        Car car = (Car) cons.newInstance("奔驰", "白色", 2000);
        return car;
    }
}
