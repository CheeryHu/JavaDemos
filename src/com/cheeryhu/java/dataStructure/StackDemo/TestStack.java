package com.cheeryhu.java.dataStructure.StackDemo;

public class TestStack {
    public static void main(String[] args) throws Exception {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("one");
        arrayStack.push("two");
        arrayStack.push("three");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.size());
    }
}
