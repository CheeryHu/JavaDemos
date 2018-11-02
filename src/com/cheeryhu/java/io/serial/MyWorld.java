package com.cheeryhu.java.io.serial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyWorld {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("dog", house));
        animals.add(new Animal("hamster", house));
        animals.add(new Animal("cat", house));
        System.out.println("animals:" + animals);

        // 写入一个输出流buf1
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals);

        // 写入一个不同的输出流buf2
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);

        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
        List anminal1 = (List) in1.readObject();
        List anminal2 = (List) in1.readObject();
        List anminal3 = (List) in2.readObject();
        System.out.println("animals1:" + anminal1);
        System.out.println("animals2:" + anminal2);
        System.out.println("animals3:" + anminal3);
    }
}

class House implements Serializable{

}

class Animal implements Serializable{
    private String name;
    private House house;

    Animal(String name, House house){
        this.name = name;
        this.house = house;
    }

    public String toString(){
        return name + "[" + super.toString() + "]" + house + "\n";
    }

}