package com.cheeryhu.java.dataStructure.QueueDemo;

import java.util.Iterator;

public class ListQueue<Item> implements MyQueue<Item> {

    private Node first;
    private Node last;
    int N = 0;

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public MyQueue<Item> add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = null;
        if (isEmpty()) {
            last = node;
            first = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
        return this;
    }

    @Override
    public Item remove() throws Exception {
        if(isEmpty()){
            throw new Exception("queue is empty!");
        }
        Node node = first;
        first = first.next;
        N--;
        if(isEmpty()){
            last = null;
        }
        return node.item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node cur = first;

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
