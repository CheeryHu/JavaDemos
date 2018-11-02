package com.cheeryhu.java.base.generic;

import java.util.Arrays;
import java.util.List;

public class GenericReading {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static class Reader<T>{
        T readExact(List<T> list){
            return list.get(0);
        }
    }

    static class CovarianReader<T>{
        T covarianReader(List<? extends T> list){
            return list.get(0);
        }
    }

    static void f1(){
        Reader<Fruit> fruitReader = new Reader<>();
//        fruitReader.readExact(apples);

    }

    static void f2(){
        CovarianReader<Fruit> fruitReader = new CovarianReader<>();
        Fruit apple = fruitReader.covarianReader(apples);
        Fruit fruit = fruitReader.covarianReader(fruits);
    }

    public static void main(String[] args){
        f1();
    }
}

class Fruit{

}

class Apple extends Fruit{

}

class Orange extends Fruit{

}