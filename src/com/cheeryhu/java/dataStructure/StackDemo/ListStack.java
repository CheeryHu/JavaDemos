package com.cheeryhu.java.dataStructure.StackDemo;

import java.util.Iterator;

public class ListStack implements MyStack<Item>{

    private Node top = null;
    private int N = 0;

    private class Node{
        Item item;
        Node next;
    }


    @Override
    public MyStack<Item> push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = top;
        top = node;
        N++;
        return this;
    }

    @Override
    public Item pop() throws Exception {
        if(isEmpty()){
            throw new Exception("stack is empty!");
        }
        Item item = top.item;
        top = top.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node cur = top;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Item next() {
                Item item = cur.item;
                cur = cur.next;
                return item;
            }
        };
    }
}
