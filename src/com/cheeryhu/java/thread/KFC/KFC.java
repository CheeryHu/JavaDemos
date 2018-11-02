package com.cheeryhu.java.thread.KFC;

import java.util.ArrayList;
import java.util.List;

public class KFC {

    String[] names = {"薯条", "烧板", "鸡翅", "可乐"};

    static final int Max = 20;

    List<Food> foods = new ArrayList<>();

    public void prod(int index){
        synchronized (this){
            while (foods.size() > Max){
                System.out.println("食材够了");
                this.notifyAll();

                try {
                    this.wait();
                    String name = Thread.currentThread().getName();
                    System.out.println("生产者:" + name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("开始生产食物");
            for (int i = 0; i < index; i++){
                Food food = new Food(names[(int)(Math.random() % 4)]);
                foods.add(food);
                System.out.println("生产了" + food.getName() + foods.size());
            }


        }
    }


    public void consu(int index){
        synchronized (this){
            while(foods.size() < index){
                System.out.println("食材不够");
                this.notifyAll();

                try {
                  this.wait();
                  String name = Thread.currentThread().getName();
                  System.out.println("消费者：" + name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("开始消费：");
            for (int i = 0; i < index; i++){
                Food food = foods.remove(foods.size() - 1);
                System.out.println("消费了一个" + food.getName() + foods.size());
            }
        }
    }

}
