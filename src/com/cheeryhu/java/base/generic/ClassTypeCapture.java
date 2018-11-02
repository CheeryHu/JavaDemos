package com.cheeryhu.java.base.generic;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {

    Class<T> kind;

    Map<String, Class<?>> map;

    public void addType(String typename, Class<?> kind){
        map.put(typename, kind);
    }

    public Object createNew(String typename) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = map.get(typename);
        return clazz.newInstance();
    }

    public ClassTypeCapture(Class<T> kind){
        this.kind = kind;
        map = new HashMap<>();
        addType(kind.getClass().getName(), kind);
    }

    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args){
        ClassTypeCapture<Building> ctc = new ClassTypeCapture<>(Building.class);


//        System.out.println(ctc.f(new Building()));
//        System.out.println(ctc.f(new House()));
//        ClassTypeCapture<House> ctc2 = new ClassTypeCapture<>(House.class);
//        System.out.println(ctc2.f(new Building()));
//        System.out.println(ctc2.f(new House()));
    }

}

class Building{}
class House extends Building{}
