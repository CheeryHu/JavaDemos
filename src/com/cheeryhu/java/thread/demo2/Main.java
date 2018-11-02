package com.cheeryhu.java.thread.demo2;

/**
 * 对同一个对象进行操作
 */
public class Main {
   public static void main(String[] args){
       Bank bank = new Bank();
       PersonA personA = new PersonA(bank);
       PersonA personA1 = new PersonA(bank);
       personA.start();
       personA1.start();
   }
}
