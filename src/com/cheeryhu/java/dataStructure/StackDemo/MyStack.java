package com.cheeryhu.java.dataStructure.StackDemo;

public interface MyStack<Item> extends Iterable<Item> {

    MyStack<Item> push(Item item);

    Item pop() throws Exception;

    boolean isEmpty();

    int size();
}
